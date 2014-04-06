package com.epiforum.server.logic.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.epiforum.server.data.entity.Account;
import com.epiforum.server.data.entity.Profile;
import com.epiforum.server.logic.utils.QueryUtils;

@Stateless
public class ProfileDao {

	@PersistenceContext(unitName="epiforum")
	protected EntityManager	em;
	
	public Profile				getProfile(Integer profileId) {
		return this.em.find(Profile.class, profileId);
	}

	public void					saveProfile(Profile profile) {
		this.em.persist(profile);
	}

	/*NEVER USE IT*/
	public void					deleteProfile(Profile profile) {
		this.em.remove(profile);
	}
	
	public Profile				getProfileFromNickname(String nickname) {
		Query query = em.createNamedQuery("Profile.getProfileFromNickname");
		query.setParameter("nickname", nickname);
		Profile pro = (Profile) QueryUtils.getSingleResultOrNull(query);
		return pro;
	}

	@SuppressWarnings("unchecked")
	public List<Profile>		getBirthdayProfiles() {
		Query query = em.createNamedQuery("Profile.getBirthdayProfiles");
		query.setParameter("status", Account.Status.ACTIVATED);
		List<Profile> pros = (List<Profile>) query.getResultList();
		if (pros != null && pros.size() > 0) {
			Date today = new Date();
			List<Profile> res = new ArrayList<Profile>();
			for (Profile pro : pros) {
				if (pro.getBirthdate() != null && DateFormatUtils.format(today, "MM-dd").equals(DateFormatUtils.format(pro.getBirthdate(), "MM-dd"))) {
					res.add(pro);
				}
			}
			if (res.size() > 0) {
				return res;
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Profile>		getTopProfiles(Integer number) {
		Query query = em.createNamedQuery("Profile.getTopProfiles");
		query.setParameter("status", Account.Status.ACTIVATED);
		query.setMaxResults(number);
		List<Profile> pros = query.getResultList();
		return pros;
	}
}
