package com.epiforum.server.logic.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

import com.epiforum.common.ro.BoardRO;
import com.epiforum.common.ro.CategoryRO;
import com.epiforum.common.ro.ContentRO;
import com.epiforum.server.config.i18n.I18n;
import com.epiforum.server.config.i18n.I18n.MessageKey;
import com.epiforum.server.config.properties.Configuration;
import com.epiforum.server.data.entity.Account.Type;
import com.epiforum.server.data.entity.Board;
import com.epiforum.server.data.entity.Category;
import com.epiforum.server.data.entity.Profile;
import com.epiforum.server.data.entity.Session;
import com.epiforum.server.logic.builder.ROBuilder;
import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.logic.exception.BadParametersException;

@Stateless
public class AdminstrationFacade extends ModerationFacade {
	
								/*	CATEGORY STUFF	*/

	public void					createCategory(HttpServletRequest request, String token, CategoryRO category) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
		if (category == null || category.getTitle() == null || category.getTitle().trim().isEmpty()) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_REQUIRED, Configuration.getDefaultLocale()));
		}
		Session se = this.sessionManager.getSession(token);
		if (!this.checkAccountType(se, Type.ADMIN)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_FORBIDEN, Configuration.getDefaultLocale()));
		}

		if (!se.getProfile().getAccount().getIpAddress().equals(request.getRemoteAddr().trim())) {
			se.getProfile().getAccount().setIpAddress(request.getRemoteAddr().trim());
		}
		se.setLastActivity("createCategory");
		Category cat = new Category(category.getTitle().trim());
		if (category.getDescription() != null && !category.getDescription().trim().isEmpty()) {
			cat.setDescription(category.getDescription());
		}
		this.categoryManager.createCategory(cat);
	}
	
	public List<ContentRO>		getAllCategories(HttpServletRequest request, String token) throws BadCredentialException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
		Session se = this.sessionManager.getSession(token);
		if (!this.checkAccountType(se, Type.ADMIN)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_FORBIDEN, Configuration.getDefaultLocale()));
		}

		if (!se.getProfile().getAccount().getIpAddress().equals(request.getRemoteAddr().trim())) {
			se.getProfile().getAccount().setIpAddress(request.getRemoteAddr().trim());
		}
		
		List<Category> cats = this.categoryManager.getAllCategories();
		if (cats != null && cats.size() > 0) {
			List<ContentRO> res = new ArrayList<ContentRO>();
			for (Category cat : cats) {
				res.add(ROBuilder.createContentRO(cat));
			}
			return res;
		}
		return null;
	}

	public Boolean				updateCategory(HttpServletRequest request, String token, CategoryRO category) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
		if (category == null || category.getId() == null ||
				category.getTitle() == null || category.getTitle().trim().isEmpty()) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_REQUIRED, Configuration.getDefaultLocale()));
		}
		Session se = this.sessionManager.getSession(token);
		if (!this.checkAccountType(se, Type.ADMIN)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_FORBIDEN, Configuration.getDefaultLocale()));
		}

		if (!se.getProfile().getAccount().getIpAddress().equals(request.getRemoteAddr().trim())) {
			se.getProfile().getAccount().setIpAddress(request.getRemoteAddr().trim());
		}
		se.setLastActivity("updateCategory");
		
		Category cat = this.categoryManager.getCategoryFromId(category.getId());
		if (cat != null) {
			return this.categoryManager.updateCategory(cat, category);
		}
		return false;
	}
	
	public Boolean				deleteCategory(HttpServletRequest request, String token, Integer categoryId) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
		if (categoryId == null) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_REQUIRED, Configuration.getDefaultLocale()));
		}
		Session se = this.sessionManager.getSession(token);
		if (!this.checkAccountType(se, Type.ADMIN)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_FORBIDEN, Configuration.getDefaultLocale()));
		}
		if (!se.getProfile().getAccount().getIpAddress().equals(request.getRemoteAddr().trim())) {
			se.getProfile().getAccount().setIpAddress(request.getRemoteAddr().trim());
		}
		se.setLastActivity("deleteCategory");
		Category cat = this.categoryManager.getCategoryFromId(categoryId);
		if (cat != null && cat.getBoards() == null || cat.getBoards().size() == 0) {
			this.categoryManager.deleteCategory(cat);
			return true;
		}
		return false;
	}

								/*	BOARD STUFF	*/

	public void					createBoard(HttpServletRequest request, String token, BoardRO bo) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
		if (bo == null || bo.getTitle() == null || bo.getTitle().trim().isEmpty()) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_REQUIRED, Configuration.getDefaultLocale()));
		}
		Session se = this.sessionManager.getSession(token);
		if (!this.checkAccountType(se, Type.ADMIN)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_FORBIDEN, Configuration.getDefaultLocale()));
		}

		if (!se.getProfile().getAccount().getIpAddress().equals(request.getRemoteAddr().trim())) {
			se.getProfile().getAccount().setIpAddress(request.getRemoteAddr().trim());
		}
		se.setLastActivity("createBoard");
		Category cat = this.categoryManager.getCategoryFromId(bo.getId());
		Board board = new Board(cat, bo.getTitle().trim());
		if (bo.getDescription() != null && !bo.getDescription().trim().isEmpty()) {
			board.setDescription(bo.getDescription().trim());
		}
		this.boardManager.createBoard(board);
	}

	public List<ContentRO>		getAllBoards(HttpServletRequest request, String token) throws BadCredentialException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
		Session se = this.sessionManager.getSession(token);
		if (!this.checkAccountType(se, Type.ADMIN)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_FORBIDEN, Configuration.getDefaultLocale()));
		}

		if (!se.getProfile().getAccount().getIpAddress().equals(request.getRemoteAddr().trim())) {
			se.getProfile().getAccount().setIpAddress(request.getRemoteAddr().trim());
		}
		
		List<Board> boards = this.boardManager.getAllBoards();
		if (boards != null && boards.size() > 0) {
			List<ContentRO> res = new ArrayList<ContentRO>();
			for (Board board : boards) {
				res.add(ROBuilder.createContentRO(board));
			}
			return res;
		}
		return null;
	}

	public Boolean				updateBoard(HttpServletRequest request, String token, BoardRO bo) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
		if (bo == null || bo.getId() == null || bo.getTitle() == null || bo.getTitle().trim().isEmpty()) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_REQUIRED, Configuration.getDefaultLocale()));
		}
		Session se = this.sessionManager.getSession(token);
		if (!this.checkAccountType(se, Type.ADMIN)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_FORBIDEN, Configuration.getDefaultLocale()));
		}

		if (!se.getProfile().getAccount().getIpAddress().equals(request.getRemoteAddr().trim())) {
			se.getProfile().getAccount().setIpAddress(request.getRemoteAddr().trim());
		}
		se.setLastActivity("updateBoard");
		Board board = this.boardManager.getBoardFromId(bo.getId());
		if (board != null) {
			return this.boardManager.updateBoard(board, bo);
		}
		return false;
	}
	
	public Boolean				deleteBoard(HttpServletRequest request, String token, Integer boardId) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
		if (boardId == null) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_REQUIRED, Configuration.getDefaultLocale()));
		}
		Session se = this.sessionManager.getSession(token);
		if (!this.checkAccountType(se, Type.ADMIN)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_FORBIDEN, Configuration.getDefaultLocale()));
		}
		if (!se.getProfile().getAccount().getIpAddress().equals(request.getRemoteAddr().trim())) {
			se.getProfile().getAccount().setIpAddress(request.getRemoteAddr().trim());
		}
		se.setLastActivity("deleteBoard");
		Board board = this.boardManager.getBoardFromId(boardId);
		if (board != null && board.getTopics() != null || board.getTopics().size() == 0) {
			this.boardManager.deleteBoard(board);
			return true;
		}
		return false;
	}
	
								/*	PROFILE STUFF	*/

	public List<String>			getAllActiveProfiles(HttpServletRequest request, String token) throws BadCredentialException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
		Session se = this.sessionManager.getSession(token);
		if (!this.checkAccountType(se, Type.ADMIN)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_FORBIDEN, Configuration.getDefaultLocale()));
		}
		if (!se.getProfile().getAccount().getIpAddress().equals(request.getRemoteAddr().trim())) {
			se.getProfile().getAccount().setIpAddress(request.getRemoteAddr().trim());
		}
		se.setLastActivity("getAllActiveProfiles");
		
		List<Profile> pros = this.profileManager.getAllActiveProfiles();
		if (pros != null && pros.size() > 0) {
			List<String> nicks = new ArrayList<String>();
			for (Profile pro : pros) {
				nicks.add(pro.getNickname());
			}
			return nicks;
		}
		return null;
	}
	
	public void					banMember(HttpServletRequest request, String token, String nickname) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
		if (nickname == null || nickname.trim().isEmpty()) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_REQUIRED, Configuration.getDefaultLocale()));
		}
		Session se = this.sessionManager.getSession(token);
		if (!this.checkAccountType(se, Type.ADMIN)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_FORBIDEN, Configuration.getDefaultLocale()));
		}
		if (!se.getProfile().getAccount().getIpAddress().equals(request.getRemoteAddr().trim())) {
			se.getProfile().getAccount().setIpAddress(request.getRemoteAddr().trim());
		}
		se.setLastActivity("banMember");
		
		Profile pro = this.profileManager.getProfileFromNickname(nickname);
		this.accountManager.removeAccount(pro.getAccount());
	}
}