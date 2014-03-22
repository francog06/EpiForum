package com.epiforum.server.logic.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.xml.registry.infomodel.User;

import org.apache.commons.lang3.RandomStringUtils;

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
			throw new BadCredentialException("Your email is empty");
		}
		if (signup.getPassword() == null || signup.getPassword().trim().isEmpty()) {
			throw new BadCredentialException("Your password is empty");
		}
		Account ac = this.accountManager.createAccount(request, signup);
		Profile pro = this.profileManager.createProfile(ac, signup);
		Application appli;
		if (appli != null) {
			System.out.println("Application name: " + appli.getName());
			this.mailManager.sendActivationMail(ac.getEmail(), ac.getActivationCode(), appli);
		}
		return ac;
	}

	public boolean				unsubscribe(HttpServletRequest request, String token, Long accountId) throws BadCredentialException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException("please login first");
		}
		Session se = this.sessionManager.getSession(token);
		Account ac = this.accountManager.getAccountFromId(accountId);
		if (!se.getProfile().equals(ac.getProfile())) {
			return false;
		}
		return this.accountManager.deleteAccount(ac);
	}

	public boolean				activateAccount(HttpServletRequest request, String userEmail, String activationCode) throws TechnicalException, BadParametersException, BadCredentialException {
		if (userEmail == null || userEmail.trim().isEmpty()) {
			throw new BadCredentialException("This email is invalid");
		} else if (activationCode == null || activationCode.trim().isEmpty()) {
			throw new BadParametersException("The activation code is invalid");
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
	
	public boolean				forgotPassword(HttpServletRequest request, String userEmail) throws TechnicalException, BadParametersException, BadCredentialException {
		if (userEmail == null || userEmail.trim().isEmpty()) {
			throw new BadCredentialException("Your email is empty");
		}
		Account ac = this.accountManager.getAccountFromEMail(userEmail);
		if (ac != null && ac.getStatus() == Account.Status.ACTIVATED) {
			String newPassword = this.accountManager.forgotEmail(ac);
			Application appli;
			this.mailManager.sendForgotPasswordEmail(ac.getEmail(), newPassword, appli);
			return true;
		} else {
			throw new BadParametersException("This user doesn't exist");
		}
	}

	public AccountRO			login(HttpServletRequest request, String token, LoginRO loginData) throws TechnicalException, BadCredentialException {
		if (loginData.getEmail() == null || loginData.getEmail().trim().isEmpty()) {
			throw new BadCredentialException("Your email is empty");
		} else if (loginData.getPassword() == null || loginData.getPassword().trim().isEmpty()) {
			throw new BadCredentialException("Your password is empty");
		} else if (token != null && this.checkSession(token)) {
			throw new BadCredentialException("You are already logged in");
		}
		Account ac = this.accountManager.loginWithEmailAndPassword(loginData.getEmail(), loginData.getPassword());
		if (!ac.getIpAddress().trim().equals(request.getRemoteAddr())) {
			ac.setIpAddress(request.getRemoteAddr());
		}
		Session se= new Session(RandomStringUtils.randomAlphanumeric(16), ac.getProfile(), "login");
		this.sessionManager.createSession(se);
		AccountRO acr = ROBuilder.createRO(ac, se);
		return acr;
	}

	public boolean				logout(String token) throws BadCredentialException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException("please login first");
		}
		Session session = this.sessionManager.getSession(token);
		if (session != null) {
			this.sessionManager.removeSession(session);
			return true;
		}
		return false;
	}

								/*	PROFILE STUFF	*/

	public UserRO				getProfileFromId(HttpServletRequest request, String token, Long profileId) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException("please login first");
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
			throw new BadCredentialException("please login first");
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

	public List<ProfileRO>		getAllProfiles(HttpServletRequest request, String token) throws BadCredentialException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException("please login first");
		}
		Session se = this.sessionManager.getSession(token);
		List<User> users = this.profileManager.getAllProfiles();
		List<UserRO> usRos = null;
		if (users != null && !users.isEmpty()) {
			usRos = new ArrayList<UserRO>();
			for (User us : users) {
				usRos.add(ROBuilder.createRO(us, null));
			}
		}
		se.setLastActivity("getAllProfiles");
		return usRos;
	}
}