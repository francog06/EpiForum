package com.epiforum.server.logic.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epiforum.server.data.entity.Session;

@Stateless
public class SessionDao {

	/*
	 * ONE SECOND IN MS
	 */
	private final long ONE_SECOND = 1000;

	@PersistenceContext(unitName="epiforum")
	protected EntityManager	em;
	
	public Session			getSession(String id) {
		return this.em.find(Session.class, id);
	}

	/*
	 * GETTING SESSIONS OLDER THAN X MINUTES
	 */
	@SuppressWarnings("unchecked")
	public List<Session>	getAllExpiredSessions(Long minutes) {
		Query query = em.createNamedQuery("Session.getAllExpiredSessions");
		long time = new Date().getTime();
		query.setParameter("date", new Date(time - (minutes * 60 * ONE_SECOND)));
		List<Session> ses = query.getResultList();
		return ses;
	}

	@SuppressWarnings("unchecked")
	public List<Session>	getAllActiveSessions(Long minutes) {
		Query query = em.createNamedQuery("Session.getAllActiveSessions");
		long time = new Date().getTime();
		query.setParameter("date", new Date(time - (minutes * 60 * ONE_SECOND)));
		List<Session> ses = query.getResultList();
		return ses;
	}

	public void			saveSession(Session session) {
		this.em.persist(session);
	}

	public void			removeSession(Session session) {
		this.em.remove(session);
	}
}
