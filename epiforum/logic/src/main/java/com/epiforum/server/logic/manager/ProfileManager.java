package com.epiforum.server.logic.manager;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epiforum.common.ro.SignupRO;
import com.epiforum.server.data.entity.Account;
import com.epiforum.server.data.entity.Profile;
import com.epiforum.server.logic.dao.ProfileDao;

@Stateless
public class ProfileManager {

	@EJB
	private ProfileDao			profileDao;

	public Profile createProfile(Account ac, SignupRO signup) {
		return null;
	}

	public Profile getProfileFromId(Long profileId) {
		// TODO Auto-generated method stub
		return null;
	}
}
