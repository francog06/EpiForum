package com.epiforum.server.logic.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.xml.registry.infomodel.User;

import org.apache.commons.lang3.RandomStringUtils;

import com.epiforum.common.ro.AccountRO;
import com.epiforum.common.ro.ChangeInfo;
import com.epiforum.common.ro.LoginRO;
import com.epiforum.common.ro.RandomPasswordRO;
import com.epiforum.common.ro.SignupRO;
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

								/*	MISC STUFF	*/

	public RandomPasswordRO		generatePassword() {
		RandomPasswordRO pass = ROBuilder.createRO(RandomStringUtils.randomAlphanumeric(16));
		return pass;
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
			throw new BadCredentialException("Votre email est invalide");
		}
		if (signup.getNickName() == null || signup.getNickName().trim().isEmpty()) {
			throw new BadCredentialException("Votre pseudo est invalide");
		}
		if (signup.getPassword() == null || signup.getPassword().trim().isEmpty()) {
			throw new BadCredentialException("Votre mot de passe est invalide");
		}
		Account ac = this.accountManager.createAccount(request, signup);
		Profile pro = this.profileManager.createProfile(ac, signup);
		Application appli = new Application();
		this.mailManager.sendActivationMail(ac.getEmail(), pro.getNickname(), ac.getActivationCode(), appli);
		return ac;
	}

	public boolean				unsubscribe(HttpServletRequest request, String token, String email) throws BadCredentialException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException("Veuillez vous connecter");
		}
		Session se = this.sessionManager.getSession(token);
		Account ac = this.accountManager.getAccountFromEMail(email);
		if (!se.getProfile().equals(ac.getProfile())) {
			return false;
		}
		return this.accountManager.deleteAccount(ac);
	}

	public boolean				activateAccount(HttpServletRequest request, String userEmail, String activationCode) throws TechnicalException, BadParametersException, BadCredentialException {
		if (userEmail == null || userEmail.trim().isEmpty()) {
			throw new BadCredentialException("Votre email est invalide");
		} else if (activationCode == null || activationCode.trim().isEmpty()) {
			throw new BadParametersException("Le code d'activation est invalide");
		}
		Account ac = this.accountManager.getAccountFromEMail(userEmail);
		if (ac != null && ac.getActivationCode().equals(activationCode) && ac.getStatus() == Account.Status.PENDING) {
			ac.setStatus(Account.Status.ACTIVATED);
			if (!ac.getIpAddress().equals(request.getRemoteAddr())) {
				ac.setIpAddress(request.getRemoteAddr());
			}
			return true;
		}
		return false;
	}
	
	public boolean				forgotPassword(HttpServletRequest request, String email) throws TechnicalException, BadParametersException, BadCredentialException {
		if (email == null || email.trim().isEmpty()) {
			throw new BadCredentialException("Votre email est invalide");
		}
		Account ac = this.accountManager.getAccountFromEMail(email);
		if (ac != null && ac.getStatus() == Account.Status.ACTIVATED) {
			String nickname = ac.getProfile().getNickname();
			String newPassword = this.accountManager.forgotPassword(ac);
			Application appli = new Application();
			this.mailManager.sendForgotPasswordEmail(ac.getEmail(), nickname, newPassword, appli);
			return true;
		} else {
			throw new BadParametersException("Ce membre n'existe pas");
		}
	}

	public String				login(HttpServletRequest request, String token, LoginRO loginData, Account.Type type) throws TechnicalException, BadCredentialException {
		if (loginData.getEmail() == null || loginData.getEmail().trim().isEmpty()) {
			throw new BadCredentialException("Votre email est invalide");
		} else if (loginData.getPassword() == null || loginData.getPassword().trim().isEmpty()) {
			throw new BadCredentialException("Votre mot de passe est invalide");
		} else if (token != null && this.checkSession(token)) {
			throw new BadCredentialException("Vous etes deja connecté");
		}
		Account ac = this.accountManager.loginWithEmailAndPassword(loginData.getEmail(), loginData.getPassword(), type);
		if (!ac.getIpAddress().trim().equals(request.getRemoteAddr())) {
			ac.setIpAddress(request.getRemoteAddr());
		}
		Session se= new Session(RandomStringUtils.randomAlphanumeric(16), ac.getProfile(), "login");
		this.sessionManager.createSession(se);
		return se.getId();
	}

	public boolean				logout(String token) throws BadCredentialException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException("Veuillez vous connecter");
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
			throw new BadCredentialException("Veuillez vous connecter");
		}
		Account ac = this.accountManager.getAccountFromEMail(info.getEmail());
		Session se = this.sessionManager.getSession(token);
		if (ac != null && se.getProfile().equals(ac.getProfile())) {
			if (info.getOldInfo().equals(ac.getEmail())) {
				ac.setEmail(info.getNewInfo());
				return true;
			}
		}
		return false;
	}
	
	public boolean				changePassword(HttpServletRequest request, String token, ChangeInfo info) throws BadCredentialException, TechnicalException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException("Veuillez vous connecter");
		}
		Account ac = this.accountManager.getAccountFromEMail(info.getEmail());
		Session se = this.sessionManager.getSession(token);
		if (ac != null && se.getProfile().equals(ac.getProfile())) {
			if (ac.getPassword().equals(this.accountManager.encodePassword(info.getNewInfo()))) {
				ac.setPassword(this.accountManager.encodePassword(info.getNewInfo()));
				return true;
			}
		}
		return false;
	}

								/*	PROFILE STUFF	*/

	public UserRO				getProfileFromId(HttpServletRequest request, String token, Long profileId) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException("Veuillez vous connecter");
		}
		Session se = this.sessionManager.getSession(token);
		Profile pro = this.profileManager.getProfileFromId(profileId);
		if (!se.getProfile().equals(pro)) {
			return null;
		}
		se.setLastActivity("getProfileFromId");
		ProfileRO user = ROBuilder.createRO(pro, se);
		return user;
	}

	public boolean				updateMyProfile(HttpServletRequest request, String token, ProfileRO proRo) throws BadCredentialException, TechnicalException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException("Veuillez vous connecter");
		}
		Session se = this.sessionManager.getSession(token);
		Profile pro = this.profileManager.getProfileFromId(proRo.getId());
		boolean match = false;
		if (pro != null && se.getProfile().equals(pro)) {
			pro = this.profileManager.updateUser(proRo);
			match = true;
		}
		se.setLastActivity("updateMyProfile");
		return match;
	}
}