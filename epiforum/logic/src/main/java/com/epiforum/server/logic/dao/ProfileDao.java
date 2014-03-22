package com.epiforum.server.logic.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epiforum.server.data.entity.Profile;
import com.epiforum.server.logic.utils.QueryUtils;

@Stateless
public class ProfileDao {

	@PersistenceContext(unitName="epiforum")
	protected EntityManager	em;
	
	public Profile		getProfile(Integer profileId) {
		return this.em.find(Profile.class, profileId);
	}

	public void			saveProfile(Profile profile) {
		this.em.persist(profile);
	}

	/*NEVER US IT*/
	public void			deleteProfile(Profile profile) {
		this.em.remove(profile);
	}
	
	public Profile		getProfileFromNickname(String nickname) {
		Query query = em.createNamedQuery("Profile.getProfileFromNickname");
		query.setParameter("nickname", nickname);
		Profile pro = (Profile) QueryUtils.getSingleResultOrNull(query);
		return pro;
	}
}
