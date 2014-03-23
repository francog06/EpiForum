package com.epiforum.server.logic.manager;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epiforum.common.ro.MyProfileRO;
import com.epiforum.common.ro.SignupRO;
import com.epiforum.server.data.entity.Account;
import com.epiforum.server.data.entity.Profile;
import com.epiforum.server.logic.application.Application;
import com.epiforum.server.logic.dao.ProfileDao;
import com.epiforum.server.logic.utils.PhoneValidator;
import com.google.i18n.phonenumbers.NumberParseException;

@Stateless
public class ProfileManager {

	@EJB
	private ProfileDao			profileDao;

	public Profile				createProfile(Account ac, SignupRO signup) {
		Profile pro = new Profile(ac, signup.getNickname().trim());
		if (signup.getFirstname() != null && !signup.getFirstname().trim().isEmpty()) {
			pro.setFirstname(signup.getFirstname().trim());
		}
		if (signup.getLastname() != null && !signup.getLastname().trim().isEmpty()) {
			pro.setLastname(signup.getLastname().trim());
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

	public Profile				updateMyProfile(Profile pro, MyProfileRO proRo) throws NumberParseException {
		if (proRo.getFirstname() != null && !proRo.getFirstname().trim().isEmpty()) {
			pro.setFirstname(proRo.getFirstname().trim());
		}
		if (proRo.getLastname() != null && !proRo.getLastname().trim().isEmpty()) {
			pro.setLastname(proRo.getLastname().trim());
		}
		if (proRo.getNickname() != null && !proRo.getNickname().trim().isEmpty()) {
			pro.setNickname(proRo.getNickname().trim());
		}
		if (proRo.getGender() != null) {
			pro.setGender(proRo.getGender());
		}
		if (proRo.getBirthdate() != null) {
			pro.setBirthdate(proRo.getBirthdate());
		}
		if (proRo.getCity() != null && !proRo.getCity().trim().isEmpty()) {
			pro.setCity(proRo.getCity().trim());
		}
		if (proRo.getFacebookPage() != null && !proRo.getFacebookPage().trim().isEmpty()) {
			pro.setFacebookPage(proRo.getFacebookPage().trim());
		}
		if (proRo.getTwitterPage() != null && !proRo.getTwitterPage().trim().isEmpty()) {
			pro.setTwitterPage(proRo.getTwitterPage().trim());
		}
		if (proRo.getSkypeContact() != null && !proRo.getSkypeContact().trim().isEmpty()) {
			pro.setSkypeContact(proRo.getSkypeContact().trim());
		}
		if (proRo.getDescription() != null && !proRo.getDescription().trim().isEmpty()) {
			pro.setDescription(proRo.getDescription().trim());
		}
		if (proRo.getSignature() != null && !proRo.getSignature().trim().isEmpty()) {
			pro.setSignature(proRo.getSignature().trim());
		}
		if (proRo.getPhone() != null && !proRo.getPhone().trim().isEmpty()) {
			if (PhoneValidator.isPhoneNumber(proRo.getPhone().trim(), Application.getCountryCode())) {
				pro.setPhone(proRo.getPhone().trim());
			}
		}
		return pro;
	}
	
	public Integer				addNbThank(Profile pro) {
		return pro.addNbThank();
	}
	
	public Integer				addNbPost(Profile pro) {
		return pro.addNbPost();
	}
}