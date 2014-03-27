package com.epiforum.server.logic.manager;

import java.security.MessageDigest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;

import com.epiforum.common.ro.SignupRO;
import com.epiforum.server.config.i18n.I18n;
import com.epiforum.server.config.i18n.I18n.MessageKey;
import com.epiforum.server.data.entity.Account;
import com.epiforum.server.data.entity.Account.Type;
import com.epiforum.server.logic.application.Application;
import com.epiforum.server.logic.dao.AccountDao;
import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.logic.exception.BadParametersException;
import com.epiforum.server.logic.exception.TechnicalException;
import com.epiforum.server.logic.utils.EmailValidator;

@Stateless
public class AccountManager {

	private static final int	PASSWORD_LEN = 40;
	
	@EJB
	private AccountDao			accountDao;

	@SuppressWarnings("restriction")
	public String				encodePassword(String clearedPassword) throws TechnicalException {
		if (clearedPassword == null || clearedPassword.trim().isEmpty()) {
			return null;
		}
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(clearedPassword.getBytes(), 0, clearedPassword.length());
			byte[] hash = new byte[PASSWORD_LEN];
			md.digest(hash, 0, PASSWORD_LEN);
			return new sun.misc.BASE64Encoder().encode(hash);
		} catch (Exception exc) {
			throw new TechnicalException(I18n.getMessage(MessageKey.ERROR_SERVER_DEFAULT, Application.getLocale()));
		}
	}

	private boolean				emailIsValid(final String email) {
		EmailValidator ev = new EmailValidator();
		return ev.validate(email);
	}
	
	private boolean				emailIsUsed(final String email) {
		return this.accountDao.emailIsUsed(email);
	}

	public Account				createAccount(HttpServletRequest request, SignupRO signup) throws BadParametersException, TechnicalException {
		if (emailIsValid(signup.getEmail().trim()) == false) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_BADEMAIL, Application.getLocale()));
		} else if (emailIsUsed(signup.getEmail().trim()) == true) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_EMAILALREADYUSED, Application.getLocale()));
		}
		Account ac = new Account();
		ac.setEmail(signup.getEmail().trim());
		ac.setPassword(this.encodePassword(signup.getPassword().trim()));
		ac.setStatus(Account.Status.PENDING);
		ac.setActivationCode(RandomStringUtils.randomAlphanumeric(16));
		ac.setIpAddress(request.getRemoteAddr().trim());
		this.accountDao.saveAccount(ac);
		return ac;
	}

	public Account				getAccountFromEMail(String email) {
		return this.accountDao.getAccountFromEmail(email);
	}

	public Account				loginWithEmailAndPassword(String email, String password, Type type) throws BadCredentialException {
		Account ac = this.accountDao.getAccountFromEmailAndPassword(email, password, type);
		if (ac == null) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_DEFAULT, Application.getLocale()));
		} else if (ac.getStatus() != Account.Status.ACTIVATED) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_ACCOUNT, Application.getLocale()));
		}
		System.out.println(email + " logged in !");
		return ac;
	}

	public String				forgotPassword(Account ac) throws TechnicalException {
		String newPass = RandomStringUtils.randomAlphanumeric(16);
		ac.setPassword(this.encodePassword(newPass));
		return newPass;
	}

	public boolean				deleteAccount(Account ac) {
		ac.setStatus(Account.Status.DISABLED);
		return false;
	}

	public Integer				countAccounts(Account.Status status) {
		return this.accountDao.countAccounts(status);
	}
}
