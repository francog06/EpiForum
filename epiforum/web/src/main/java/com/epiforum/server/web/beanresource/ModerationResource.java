package com.epiforum.server.web.beanresource;

import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;

import com.epiforum.server.logic.facade.ModerationFacade;

/**
 * Servlet implementation class ModerationResource
 */
public abstract class ModerationResource extends HttpServlet {

	private static final long		serialVersionUID = 276623439749697200L;

	@EJB
	protected ModerationFacade		moderationFacade;
}
