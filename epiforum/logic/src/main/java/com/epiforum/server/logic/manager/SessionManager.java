package com.epiforum.server.logic.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epiforum.server.data.entity.Session;
import com.epiforum.server.logic.dao.SessionDao;

@Stateless
public class SessionManager {

	@EJB
	private SessionDao		sessionDao;

	public boolean		checkSession(String token) {
		return this.sessionDao.getSession(token) != null ? true : false;
	}
	
	public Session			getSession(String token) {
		return this.sessionDao.getSession(token);
	}
	
	public void				createSession(Session session) {
		this.sessionDao.saveSession(session);
	}
	
	public void				removeSession(Session session) {
		this.sessionDao.removeSession(session);
	}
	
	public List<Session>	getAllExpiredSessions(Long minutes) {
		return this.sessionDao.getAllExpiredSessions(minutes);
	}
	
	public List<Session>	getAllActiveSessions(Long minutes) {
		return this.sessionDao.getAllActiveSessions(minutes);
	}
}
