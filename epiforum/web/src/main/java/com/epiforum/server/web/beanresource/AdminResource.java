package com.epiforum.server.web.beanresource;

import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;

import com.epiforum.server.logic.facade.AdminstrationFacade;

/**
 * Servlet implementation class AdminResource
 */
public abstract class AdminResource extends HttpServlet {

	private static final long		serialVersionUID = -2846518367098535070L;
	
	@EJB
	protected AdminstrationFacade	adminFacade;
}