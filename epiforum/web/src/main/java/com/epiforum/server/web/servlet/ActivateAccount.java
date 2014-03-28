package com.epiforum.server.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.logic.exception.BadParametersException;
import com.epiforum.server.logic.exception.TechnicalException;
import com.epiforum.server.web.beanresource.OperationResource;

/**
 * Servlet implementation class ActivateAccount
 */
@WebServlet("/activateAccount")
public class ActivateAccount extends OperationResource {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ActivateAccount() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("n") != null && request.getParameter("c") != null) {
			String email = request.getParameter("n");
			String activationCode = request.getParameter("c");
			try {
				this.operationFacade.activateAccount(request, email.trim(), activationCode.trim());
				response.sendRedirect("/web/login");
			} catch (TechnicalException e) {
				e.printStackTrace();
			} catch (BadParametersException e) {
				e.printStackTrace();
			} catch (BadCredentialException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
