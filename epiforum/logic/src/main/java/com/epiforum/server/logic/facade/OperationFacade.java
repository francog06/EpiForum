package com.epiforum.server.logic.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;

import com.epiforum.common.ro.BoardRO;
import com.epiforum.common.ro.CategoryRO;
import com.epiforum.common.ro.ChangeInfo;
import com.epiforum.common.ro.ContentRO;
import com.epiforum.common.ro.LightProfileRO;
import com.epiforum.common.ro.LoginRO;
import com.epiforum.common.ro.MemberRO;
import com.epiforum.common.ro.MyLightProfileRO;
import com.epiforum.common.ro.MyProfileRO;
import com.epiforum.common.ro.PaginationRO;
import com.epiforum.common.ro.PostRO;
import com.epiforum.common.ro.ProfileInfoRO;
import com.epiforum.common.ro.SignupRO;
import com.epiforum.common.ro.TopTopicRO;
import com.epiforum.common.ro.TopicRO;
import com.epiforum.server.config.i18n.I18n;
import com.epiforum.server.config.i18n.I18n.MessageKey;
import com.epiforum.server.data.entity.Account;
import com.epiforum.server.data.entity.Board;
import com.epiforum.server.data.entity.Category;
import com.epiforum.server.data.entity.ContentPost;
import com.epiforum.server.data.entity.Post;
import com.epiforum.server.data.entity.Profile;
import com.epiforum.server.data.entity.Session;
import com.epiforum.server.data.entity.Topic;
import com.epiforum.server.logic.application.Application;
import com.epiforum.server.logic.builder.ROBuilder;
import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.logic.exception.BadParametersException;
import com.epiforum.server.logic.exception.TechnicalException;
import com.epiforum.server.logic.manager.AccountManager;
import com.epiforum.server.logic.manager.BoardManager;
import com.epiforum.server.logic.manager.CategoryManager;
import com.epiforum.server.logic.manager.ContentPostManager;
import com.epiforum.server.logic.manager.MailManager;
import com.epiforum.server.logic.manager.PostManager;
import com.epiforum.server.logic.manager.ProfileManager;
import com.epiforum.server.logic.manager.SessionManager;
import com.epiforum.server.logic.manager.TopicManager;
import com.google.i18n.phonenumbers.NumberParseException;

@Stateless
public class OperationFacade {

	@EJB
	protected AccountManager		accountManager;

	@EJB
	protected ProfileManager		profileManager;

	@EJB
	protected CategoryManager		categoryManager;
	
	@EJB
	protected BoardManager			boardManager;
	
	@EJB
	protected TopicManager			topicManager;
	
	@EJB
	protected PostManager			postManager;
	
	@EJB
	protected ContentPostManager	contentPostManager;

	@EJB
	protected SessionManager		sessionManager;
	
	@EJB
	protected MailManager			mailManager;

								/*	MISC	*/

	public String				generateStrongString() {
		String strong = RandomStringUtils.randomAlphanumeric(16);
		return strong;
	}

	public boolean				checkSession(String token) {
		if (token != null && !token.trim().isEmpty()) {
			return this.sessionManager.checkSession(token);
		}
		return false;
	}

								/*	ACCOUNT STUFF	*/

	public Account				subscribe(HttpServletRequest request, SignupRO signup) throws BadCredentialException, TechnicalException, BadParametersException {
		if (signup.getEmail() == null || signup.getEmail().trim().isEmpty()) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_EMAIL, Application.getLocale()));
		}
		if (signup.getNickname() == null || signup.getNickname().trim().isEmpty()) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_NICKNAME, Application.getLocale()));
		}
		if (signup.getPassword() == null || signup.getPassword().trim().isEmpty()) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_PASSWORD, Application.getLocale()));
		}
		Account ac = this.accountManager.createAccount(request, signup);
		Profile pro = this.profileManager.createProfile(ac, signup);
		this.mailManager.sendActivationMail(ac.getEmail(), pro.getNickname(), ac.getActivationCode());
		return ac;
	}

	public Boolean				unsubscribe(HttpServletRequest request, String token, String email) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Application.getLocale()));
		}
		if (email == null || email.trim().isEmpty()) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_BADEMAIL, Application.getLocale()));
		}
		Session se = this.sessionManager.getSession(token);
		Account ac = this.accountManager.getAccountFromEMail(email);
		if (!se.getProfile().equals(ac.getProfile())) {
			return false;
		}
		return this.accountManager.deleteAccount(ac);
	}

	public Boolean				activateAccount(HttpServletRequest request, String email, String activationCode) throws TechnicalException, BadParametersException, BadCredentialException {
		if (email == null || email.trim().isEmpty()) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_BADEMAIL, Application.getLocale()));
		} else if (activationCode == null || activationCode.trim().isEmpty()) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_BADACTIVATIONCODE, Application.getLocale()));
		}
		Account ac = this.accountManager.getAccountFromEMail(email);
		if (ac != null && ac.getActivationCode().equals(activationCode) && ac.getStatus() == Account.Status.PENDING) {
			ac.setStatus(Account.Status.ACTIVATED);
			if (!ac.getIpAddress().equals(request.getRemoteAddr().trim())) {
				ac.setIpAddress(request.getRemoteAddr().trim());
			}
			return true;
		}
		return false;
	}
	
	public Boolean				forgotPassword(HttpServletRequest request, String email) throws TechnicalException, BadParametersException, BadCredentialException {
		if (email == null || email.trim().isEmpty()) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_BADEMAIL, Application.getLocale()));
		}
		Account ac = this.accountManager.getAccountFromEMail(email);
		if (ac != null && ac.getStatus() == Account.Status.ACTIVATED) {
			String nickname = ac.getProfile().getNickname();
			String newPassword = this.accountManager.forgotPassword(ac);
			this.mailManager.sendForgotPasswordEmail(ac.getEmail(), nickname, newPassword);
			return true;
		} else {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_BADACCOUNT, Application.getLocale()));
		}
	}

	public String				login(HttpServletRequest request, String token, LoginRO loginData, Account.Type type) throws TechnicalException, BadCredentialException {
		if (loginData.getEmail() == null || loginData.getEmail().trim().isEmpty()) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_EMAIL, Application.getLocale()));
		} else if (loginData.getPassword() == null || loginData.getPassword().trim().isEmpty()) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_PASSWORD, Application.getLocale()));
		} else if (token != null && this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGED, Application.getLocale()));
		}
		Account ac = this.accountManager.loginWithEmailAndPassword(loginData.getEmail(), loginData.getPassword(), type);
		if (!ac.getIpAddress().trim().equals(request.getRemoteAddr().trim())) {
			ac.setIpAddress(request.getRemoteAddr().trim());
		}
		Session se= new Session(this.generateStrongString(), ac.getProfile(), "Login");
		this.sessionManager.createSession(se);
		return se.getId();
	}

	public Boolean				logout(String token) throws BadCredentialException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_NOLOGIN, Application.getLocale()));
		}
		Session session = this.sessionManager.getSession(token);
		if (session != null) {
			this.sessionManager.removeSession(session);
			return true;
		}
		return false;
	}

	public Boolean				changeEmail(HttpServletRequest request, String token, ChangeInfo info) throws BadCredentialException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Application.getLocale()));
		}
		Account ac = this.accountManager.getAccountFromEMail(info.getEmail());
		Session se = this.sessionManager.getSession(token);
		if (ac != null && se.getProfile().equals(ac.getProfile())) {
			if (info.getOldInfo().trim().equals(ac.getEmail().trim())) {
				ac.setEmail(info.getNewInfo().trim());
				if (!ac.getIpAddress().equals(request.getRemoteAddr().trim())) {
					ac.setIpAddress(request.getRemoteAddr().trim());
				}
				return true;
			}
		}
		se.setLastActivity("changeEmail");
		return false;
	}
	
	public Boolean				changePassword(HttpServletRequest request, String token, ChangeInfo info) throws BadCredentialException, TechnicalException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Application.getLocale()));
		}
		Account ac = this.accountManager.getAccountFromEMail(info.getEmail());
		Session se = this.sessionManager.getSession(token);
		if (ac != null && se.getProfile().equals(ac.getProfile())) {
			if (ac.getPassword().trim().equals(this.accountManager.encodePassword(info.getOldInfo().trim()))) {
				ac.setPassword(this.accountManager.encodePassword(info.getNewInfo().trim()));
				if (!ac.getIpAddress().equals(request.getRemoteAddr().trim())) {
					ac.setIpAddress(request.getRemoteAddr().trim());
				}
				return true;
			}
		}
		se.setLastActivity("changePassword");
		return false;
	}

								/*	PROFILE STUFF	*/

	public ProfileInfoRO		viewProfile(HttpServletRequest request, String token, String nickname) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Application.getLocale()));
		}
		if (nickname == null || nickname.trim().isEmpty()) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_BADNICKNAME, Application.getLocale()));
		}
		Session se = this.sessionManager.getSession(token);
		Profile pro = this.profileManager.getProfileFromNickname(nickname);
		MyProfileRO user = null;
		if (!se.getProfile().equals(pro)) {
			// profil d'un membre
			user = ROBuilder.createMyProfileRO(pro, null);
		} else {
			// mon profil
			user = ROBuilder.createMyProfileRO(pro, se);
		}
		if (!se.getProfile().getAccount().getIpAddress().equals(request.getRemoteAddr().trim())) {
			se.getProfile().getAccount().setIpAddress(request.getRemoteAddr().trim());
		}
		se.setLastActivity("viewProfile");
		return user;
	}

	public Boolean				updateMyProfile(HttpServletRequest request, String token, MyProfileRO myPro) throws BadCredentialException, TechnicalException, BadParametersException, NumberParseException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Application.getLocale()));
		}
		if (myPro.getNickname() == null || myPro.getNickname().trim().isEmpty()) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_BADNICKNAME, Application.getLocale()));
		}
		Session se = this.sessionManager.getSession(token);
		Profile pro = this.profileManager.getProfileFromNickname(myPro.getNickname());
		boolean match = false;
		if (pro != null && se.getProfile().equals(pro)) {
			pro = this.profileManager.updateMyProfile(pro, myPro);
			if (!pro.getAccount().getIpAddress().equals(request.getRemoteAddr().trim())) {
				pro.getAccount().setIpAddress(request.getRemoteAddr().trim());
			}
			match = true;
		}
		se.setLastActivity("updateMyProfile");
		return match;
	}
	
	public Integer				thankProfile(HttpServletRequest request, String token, String nickname) throws BadCredentialException, TechnicalException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Application.getLocale()));
		}
		if (nickname == null || nickname.trim().isEmpty()) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_BADNICKNAME, Application.getLocale()));
		}
		Session se = this.sessionManager.getSession(token);
		Profile pro = this.profileManager.getProfileFromNickname(nickname);
		if (!se.getProfile().getAccount().getIpAddress().equals(request.getRemoteAddr().trim())) {
			se.getProfile().getAccount().setIpAddress(request.getRemoteAddr().trim());
		}
		se.setLastActivity("thankProfile");
		if (!se.getProfile().equals(pro)) {
			return this.profileManager.addNbThank(pro);
		}
		return 0;
	}

	public MyLightProfileRO		getMyLightProfileRO(HttpServletRequest request, String token) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Application.getLocale()));
		}
		Session se = this.sessionManager.getSession(token);
		MyLightProfileRO pro = ROBuilder.createMyLightProfileRO(se.getProfile());
		return pro;
	}

								/*	TOPIC STUFF	*/

	public TopicRO				createTopic(HttpServletRequest request, String token, TopicRO topicRo) throws BadCredentialException, TechnicalException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Application.getLocale()));
		}
		if (topicRo == null || topicRo.getId() == 0 || topicRo.getPost() == null) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_DEFAULT, Application.getLocale()));
		}
		if (topicRo.getPost().getContent() == null || topicRo.getPost().getContent().trim().isEmpty()) {
			throw new BadParametersException(String.format(I18n.getMessage(MessageKey.ERROR_PARAMETER_REQUIRED, Application.getLocale()), "Message"));
		}
		Session se = this.sessionManager.getSession(token);
		Board board = this.boardManager.getBoardFromId(topicRo.getId());
		Topic topic = this.topicManager.createTopic(topicRo, board);
		Post post = this.postManager.createPost(topicRo.getPost(), topic, se.getProfile());
		ContentPost content = this.contentPostManager.createContentPost(topicRo.getPost().getContent(), post);
		TopicRO res = ROBuilder.createTopicRO(topic);
		res.setPost(ROBuilder.createPostRO(post, se.getProfile().getId(), content.getContent()));
		if (!se.getProfile().getAccount().getIpAddress().equals(request.getRemoteAddr().trim())) {
			se.getProfile().getAccount().setIpAddress(request.getRemoteAddr().trim());
		}
		se.setLastActivity("createTopic");
		return res;
	}
	
	public TopicRO				viewTopic(HttpServletRequest request, String token, PaginationRO pagination) throws BadCredentialException, TechnicalException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Application.getLocale()));
		}
		if (pagination.getId() == null || pagination.getStartIndex() == null) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_DEFAULT, Application.getLocale()));
		}
		Topic topic = this.topicManager.getTopicFromId(pagination.getId());
		if (topic == null) {
			return null;
		}
		Session se = this.sessionManager.getSession(token);
		List<Post>  posts = this.postManager.getAllPostNotDeleted(pagination.getId(), pagination.getStartIndex());
		List<PostRO> poRos = null;
		List<LightProfileRO> pros = null;
		if (posts != null && posts.size() > 0) {
			poRos = new ArrayList<PostRO>();
			pros = new ArrayList<LightProfileRO>();
			for (Post post : posts) {
				pros.add(ROBuilder.createLightProfileRO(post.getProfile()));
				poRos.add(ROBuilder.createPostRO(post));
			}
		}
		TopicRO to = ROBuilder.createTopicRO(topic);
		to.setProfiles(pros);
		to.setPosts(poRos);
		if (!se.getProfile().getAccount().getIpAddress().equals(request.getRemoteAddr().trim())) {
			se.getProfile().getAccount().setIpAddress(request.getRemoteAddr().trim());
		}
		se.setLastActivity("viewTopic");
		return to;
	}

								/*	POST STUFF	*/

	public Boolean				addPost(HttpServletRequest request, String token, PostRO postRo) throws BadCredentialException, TechnicalException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Application.getLocale()));
		}
		if (postRo.getPostId() == null || postRo.getPostId() == 0) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_DEFAULT, Application.getLocale()));
		}
		Session se = this.sessionManager.getSession(token);
		Topic topic = this.topicManager.getTopicFromId(postRo.getTopicId());
		Post post = this.postManager.createPost(postRo, topic, se.getProfile());
		ContentPost content = this.contentPostManager.createContentPost(postRo.getContent(), post);
		if (!se.getProfile().getAccount().getIpAddress().equals(request.getRemoteAddr().trim())) {
			se.getProfile().getAccount().setIpAddress(request.getRemoteAddr().trim());
		}
		se.setLastActivity("addPost");
		return content != null ? true : false;
	}

	
	public Boolean				updateMyPost(HttpServletRequest request, String token, ContentRO contentRo) throws BadCredentialException, TechnicalException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Application.getLocale()));
		}
		if (contentRo == null || contentRo.getPostId() == null) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_DEFAULT, Application.getLocale()));
		}
		if (contentRo.getContent() == null || contentRo.getContent().trim().isEmpty()) {
			throw new BadParametersException(String.format(I18n.getMessage(MessageKey.ERROR_PARAMETER_REQUIRED, Application.getLocale()), "Message"));
		}
		Session se = this.sessionManager.getSession(token);
		Post post = this.postManager.getPostFromId(contentRo.getPostId());
		ContentPost content = null;
		if (post.getProfile().equals(se.getProfile())) {
			content = this.contentPostManager.updateContentPost(post.getContentPost(), contentRo.getContent());
		}
		if (!se.getProfile().getAccount().getIpAddress().equals(request.getRemoteAddr().trim())) {
			se.getProfile().getAccount().setIpAddress(request.getRemoteAddr().trim());
		}
		se.setLastActivity("updateMyPost");
		return content != null ? true : false;
	}

	public Boolean				removeMyPost(HttpServletRequest request, String token, Integer postId) throws BadCredentialException, TechnicalException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Application.getLocale()));
		}
		if (postId == null || postId == 0) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_DEFAULT, Application.getLocale()));
		}
		Session se = this.sessionManager.getSession(token);
		Post post = this.postManager.getPostFromId(postId);
		Boolean success = false;
		if (post.getProfile().equals(se.getProfile())) {
			success = this.postManager.removePost(post);
		}
		if (!se.getProfile().getAccount().getIpAddress().equals(request.getRemoteAddr().trim())) {
			se.getProfile().getAccount().setIpAddress(request.getRemoteAddr().trim());
		}
		se.setLastActivity("removeMyPost");
		return success;
	}

								/*	CATEGORY STUFF	*/

	public List<CategoryRO>		viewAllCategories(HttpServletRequest request, String token) {
		List<Category> cats = this.categoryManager.getAllCategories();
		if (cats == null || cats.size() == 0) {
			return null;
		}
		Session se = this.sessionManager.getSession(token);
		List<CategoryRO> catRos = new ArrayList<CategoryRO>();
		for (Category cat : cats) {
			CategoryRO catRo = ROBuilder.createCategoryRO(cat);
			if (cat.getBoards() != null || cat.getBoards().size() > 0) {
				List<BoardRO> boards = new ArrayList<BoardRO>();
				for (Board board : cat.getBoards()) {
					boards.add(ROBuilder.createBoardRO(board));
				}
				catRo.setBoards(boards);
			}
			catRos.add(catRo);
		}
		if (se != null) {
			if (!se.getProfile().getAccount().getIpAddress().equals(request.getRemoteAddr().trim())) {
				se.getProfile().getAccount().setIpAddress(request.getRemoteAddr().trim());
			}
			se.setLastActivity("viewAllCategories");
		}
		return catRos;
		
	}

	public CategoryRO			viewCategory(HttpServletRequest request, String token, Integer categoryId) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Application.getLocale()));
		}
		if (categoryId == null) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_DEFAULT, Application.getLocale()));
		}
		Category cat = this.categoryManager.getCategoryFromId(categoryId);
		if (cat == null) {
			return null;
		}
		CategoryRO catRo = ROBuilder.createCategoryRO(cat);
		Session se = this.sessionManager.getSession(token);
		List<BoardRO> boards = null;
		if (cat.getBoards() != null && cat.getBoards().size() > 0) {
			boards = new ArrayList<BoardRO>();
			for (Board board : cat.getBoards()) {
				boards.add(ROBuilder.createBoardRO(board));
			}
			catRo.setBoards(boards);
		}
		if (!se.getProfile().getAccount().getIpAddress().equals(request.getRemoteAddr().trim())) {
			se.getProfile().getAccount().setIpAddress(request.getRemoteAddr().trim());
		}
		se.setLastActivity("viewAllBoardsFromCategoryId");
		return catRo;
	}

								/*	BOARD STUFF	*/

	public BoardRO				viewBoard(HttpServletRequest request, String token, Integer boardId) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Application.getLocale()));
		}
		if (boardId == null) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_DEFAULT, Application.getLocale()));
		}
		Board board = this.boardManager.getBoardFromId(boardId);
		if (board == null) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_DEFAULT, Application.getLocale()));
		}
		BoardRO boardRo = ROBuilder.createBoardRO(board);
		Session se = this.sessionManager.getSession(token);
		List<TopicRO> topics = null;
		if (board.getTopics() != null && board.getTopics().size() > 0) {
			topics = new ArrayList<TopicRO>();
			for (Topic topic : board.getTopics()) {
				topics.add(ROBuilder.createTopicRO(topic));
			}
			boardRo.setTopics(topics);
		}
		if (!se.getProfile().getAccount().getIpAddress().equals(request.getRemoteAddr().trim())) {
			se.getProfile().getAccount().setIpAddress(request.getRemoteAddr().trim());
		}
		se.setLastActivity("viewAllTopicsFromBoardId");
		return boardRo;
	}

								/*	STATISTICS STUFF	*/

	public Integer				numberOfMembers() {
		if (this.accountManager.countAccounts(Account.Status.ACTIVATED) != null) {
			return this.accountManager.countAccounts(Account.Status.ACTIVATED);
		}
		return 0;
	}

	public Integer				numberOfPosts() {
		if (this.postManager.countPosts() != null) {
			return this.postManager.countPosts();
		}
		return 0;
	}


	public Integer				numberOfTopics() {
		if (this.topicManager.countTopics() != null) {
			return this.topicManager.countTopics();
		}
		return 0;
	}

	public List<MemberRO>		connectedMembers() {
		List<Session> ses = this.sessionManager.getAllActiveSessions(10l);
		if (ses == null || ses.size() == 0) {
			return null;
		}
		List<MemberRO> members = new ArrayList<MemberRO>();
		for (Session se : ses) {
			members.add(ROBuilder.createMemberRO(se.getProfile()));
		}
		return null;
	}

	public List<MemberRO>		birthdayMembers() {
		List<Profile> pros = this.profileManager.getBirthdayProfiles();
		if (pros == null || pros.size() == 0) {
			return null;
		}
		List<MemberRO> members = new ArrayList<MemberRO>();
		for (Profile pro : pros) {
			members.add(ROBuilder.createMemberRO(pro));
		}
		return members;
	}

	public List<MemberRO>		topMembers() {
		List<Profile> pros = this.profileManager.getTopMembers(3);
		if (pros == null || pros.size() == 0) {
			return null;
		}
		List<MemberRO> members = new ArrayList<MemberRO>();
		for (Profile pro : pros) {
			members.add(ROBuilder.createMemberRO(pro));
		}
		return members;
	}

	/*TODO topTopics*/
	public List<TopTopicRO>		topTopics() {
		return null;
	}
}