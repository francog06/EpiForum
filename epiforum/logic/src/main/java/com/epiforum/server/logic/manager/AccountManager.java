package com.epiforum.server.logic.manager;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epiforum.server.logic.dao.AccountDao;

@Stateless
public class AccountManager {

	@EJB
	private AccountDao			accountDao;
}
