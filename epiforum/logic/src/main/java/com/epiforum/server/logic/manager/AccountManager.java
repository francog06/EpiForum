package com.epiforum.server.logic.manager;

import java.security.MessageDigest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;

import com.epiforum.common.ro.SignupRO;
import com.epiforum.server.data.entity.Account;
import com.epiforum.server.data.entity.Account.Type;
import com.epiforum.server.logic.dao.AccountDao;
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
			throw new TechnicalException("Something went wrong during password encoding.");
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
		if (emailIsValid(signup.getEmail()) == false) {
			throw new BadParametersException("Votre email n'est pas valide");
		} else if (emailIsUsed(signup.getEmail()) == true) {
			throw new BadParametersException("Cet email est en cours d'utilisation");
		}
		Account ac = new Account();
		ac.setEmail(signup.getEmail());
		ac.setPassword(this.encodePassword(signup.getPassword()));
		ac.setStatus(Account.Status.PENDING);
		ac.setActivationCode(RandomStringUtils.randomAlphanumeric(16));
		ac.setIpAddress(request.getRemoteAddr());
		this.accountDao.saveAccount(ac);
		return ac;
	}

	public Account				loginWithEmailAndPassword(String email, String password, Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	public Account				getAccountFromEMail(String userEmail) {
		// TODO Auto-generated method stub
		return null;
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
}
