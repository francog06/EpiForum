package com.epiforum.server.logic.task;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

import com.epiforum.server.data.entity.Session;
import com.epiforum.server.logic.manager.SessionManager;

@Singleton
public class CleanSession {

	private final long		MINUTES = 10;

	@EJB
	private SessionManager	sessionManager;

	@Schedule(hour="*", minute="*/30", second="0", info = "Cleaning expired sessions every 15 minutes")
    public void		run() {
		System.out.println("<-- Cleaning table session BEGIN -->");
        List<Session> ses = this.sessionManager.getAllExpiredSessions(MINUTES);
        if (ses != null && !ses.isEmpty()) {
        	int n = ses.size();
        	for (Session se : ses) {
				this.sessionManager.removeSession(se);
			}
        	System.out.println(n + " sessions removed");
        }
        System.out.println("<-- Cleaning table session END -->");
    }
}