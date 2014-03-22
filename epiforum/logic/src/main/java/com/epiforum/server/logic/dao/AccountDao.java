package com.epiforum.server.logic.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epiforum.server.data.entity.Account;
import com.epiforum.server.logic.utils.QueryUtils;

@Stateless
public class AccountDao {
	
	@PersistenceContext(unitName="epiforum")
	protected EntityManager	em;

	public Account		getAccount(Long accountId) {
		return this.em.find(Account.class, accountId);
	}

	public void			saveAccount(Account account) {
		this.em.persist(account);
	}

	/*NEVER US IT*/
	public void			deleteAccount(Account account) {
		this.em.remove(account);
	}

	public boolean		emailIsUsed(final String email) {
		Query query = em.createNamedQuery("Account.emailIsUsed");
		query.setParameter("email", email);
		return QueryUtils.getSingleResultOrNull(query) != null;
	}

	public Account			getAccountFromEmail(String email) {
		Query query = em.createNamedQuery("Account.getAccountFromEmail");
		query.setParameter("email", email);
		Account result = (Account) QueryUtils.getSingleResultOrNull(query);
		return result;
	}

	public Account			getAccountFromEmailAndPassword(final String email, final String password, Account.Type type) {
		Query query = em.createNamedQuery("Account.getAccountFromEmailAndPassword");
		query.setParameter("email", email);
		query.setParameter("password", password);
		query.setParameter("status", Account.Status.ACTIVATED);
		query.setParameter("type", type);
		Account result = (Account) QueryUtils.getSingleResultOrNull(query);
		return result;
	}
}
