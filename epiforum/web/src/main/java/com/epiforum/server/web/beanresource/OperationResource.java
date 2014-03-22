package com.epiforum.server.web.beanresource;

import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;

import com.epiforum.server.logic.facade.OperationFacade;

public abstract class OperationResource extends HttpServlet {

	private static final long		serialVersionUID = -2268430199067367626L;

	@EJB
	protected OperationFacade		operationFacade;
}
