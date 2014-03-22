package com.epiforum.server.logic.manager;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epiforum.common.ro.MyProfileRO;
import com.epiforum.common.ro.SignupRO;
import com.epiforum.server.data.entity.Account;
import com.epiforum.server.data.entity.Profile;
import com.epiforum.server.logic.dao.ProfileDao;

@Stateless
public class ProfileManager {

	@EJB
	private ProfileDao			profileDao;

	public Profile				createProfile(Account ac, SignupRO signup) {
		Profile pro = new Profile(ac, signup.getNickName());
		if (signup.getFirstName() != null && !signup.getFirstName().trim().isEmpty()) {
			pro.setFirstname(signup.getFirstName());
		}
		if (signup.getLastName() != null && !signup.getLastName().trim().isEmpty()) {
			pro.setLastname(signup.getLastName());
		}
		this.profileDao.saveProfile(pro);
		return null;
	}

	public Profile				getProfileFromNickname(String nickname) {
		return this.profileDao.getProfileFromNickname(nickname);
	}

	public Profile				getProfileFromId(Integer profileId) {
		return this.profileDao.getProfile(profileId);
	}

	public Profile updateProfile(MyProfileRO proRo) {
		// TODO Auto-generated method stub
		return null;
	}
}