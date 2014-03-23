package com.epiforum.server.logic.facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;

import com.epiforum.common.ro.ChangeInfo;
import com.epiforum.common.ro.LoginRO;
import com.epiforum.common.ro.MyProfileRO;
import com.epiforum.common.ro.ProfileInfoRO;
import com.epiforum.common.ro.SignupRO;
import com.epiforum.server.config.i18n.I18n;
import com.epiforum.server.config.i18n.I18n.MessageKey;
import com.epiforum.server.data.entity.Account;
import com.epiforum.server.data.entity.Profile;
import com.epiforum.server.data.entity.Session;
import com.epiforum.server.logic.application.Application;
import com.epiforum.server.logic.builder.ROBuilder;
import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.logic.exception.BadParametersException;
import com.epiforum.server.logic.exception.TechnicalException;
import com.epiforum.server.logic.manager.AccountManager;
import com.epiforum.server.logic.manager.BoardManager;
import com.epiforum.server.logic.manager.CategoryManager;
import com.epiforum.server.logic.manager.MailManager;
import com.epiforum.server.logic.manager.PostManager;
import com.epiforum.server.logic.manager.ProfileManager;
import com.epiforum.server.logic.manager.SessionManager;
import com.epiforum.server.logic.manager.TopicManager;
import com.google.i18n.phonenumbers.NumberParseException;

@Stateless
public class OperationFacade {

	@EJB
	private AccountManager		accountManager;

	@EJB
	private ProfileManager		profileManager;

	@EJB
	private CategoryManager		categoryManager;
	
	@EJB
	private BoardManager		boardManager;
	
	@EJB
	private TopicManager		topicManager;
	
	@EJB
	private PostManager			postManager;

	@EJB
	private SessionManager		sessionManager;
	
	@EJB
	private MailManager			mailManager;

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

	public boolean				unsubscribe(HttpServletRequest request, String token, String email) throws BadCredentialException, BadParametersException {
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

	public boolean				activateAccount(HttpServletRequest request, String email, String activationCode) throws TechnicalException, BadParametersException, BadCredentialException {
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
	
	public boolean				forgotPassword(HttpServletRequest request, String email) throws TechnicalException, BadParametersException, BadCredentialException {
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

	public boolean				logout(String token) throws BadCredentialException {
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

	public boolean				changeEmail(HttpServletRequest request, String token, ChangeInfo info) throws BadCredentialException {
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
	
	public boolean				changePassword(HttpServletRequest request, String token, ChangeInfo info) throws BadCredentialException, TechnicalException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Application.getLocale()));
		}
		Account ac = this.accountManager.getAccountFromEMail(info.getEmail());
		Session se = this.sessionManager.getSession(token);
		if (ac != null && se.getProfile().equals(ac.getProfile())) {
			if (ac.getPassword().trim().equals(this.accountManager.encodePassword(info.getNewInfo().trim()))) {
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

	public ProfileInfoRO		getProfileFromNickname(HttpServletRequest request, String token, String nickname) throws BadCredentialException, BadParametersException {
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
			user = ROBuilder.createRO(pro, null);
		} else {
			// mon profil
			user = ROBuilder.createRO(pro, se);
		}
		if (!pro.getAccount().getIpAddress().equals(request.getRemoteAddr().trim())) {
			pro.getAccount().setIpAddress(request.getRemoteAddr().trim());
		}
		se.setLastActivity("getProfileFromNickname");
		return user;
	}

	public boolean				updateMyProfile(HttpServletRequest request, String token, MyProfileRO proRo) throws BadCredentialException, TechnicalException, BadParametersException, NumberParseException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Application.getLocale()));
		}
		if (proRo.getNickname() == null || proRo.getNickname().trim().isEmpty()) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_BADNICKNAME, Application.getLocale()));
		}
		Session se = this.sessionManager.getSession(token);
		Profile pro = this.profileManager.getProfileFromNickname(proRo.getNickname());
		boolean match = false;
		if (pro != null && se.getProfile().equals(pro)) {
			pro = this.profileManager.updateMyProfile(pro, proRo);
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
		if (!se.getProfile().equals(pro)) {
			return this.profileManager.addNbThank(pro);
		}
		if (!pro.getAccount().getIpAddress().equals(request.getRemoteAddr().trim())) {
			pro.getAccount().setIpAddress(request.getRemoteAddr().trim());
		}
		return 0;
	}
}