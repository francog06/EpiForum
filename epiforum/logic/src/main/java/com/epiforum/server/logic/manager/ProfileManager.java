package com.epiforum.server.logic.manager;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epiforum.server.logic.dao.ProfileDao;

@Stateless
public class ProfileManager {

	@EJB
	private ProfileDao			profileDao;
}
