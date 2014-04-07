package com.epiforum.server.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.web.beanresource.OperationResource;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/logout")
public class Logout extends OperationResource {

	private static final long serialVersionUID = -8143676666774691174L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession(false);
		request.setCharacterEncoding("UTF-8");
		if (se != null) {
			String token = (String) se.getAttribute("Authorization");
		    try {
				this.operationFacade.logout(token);
			} catch (BadCredentialException e) {
				e.printStackTrace();
			}
		    se.invalidate();
		    }
	    response.sendRedirect("home");
	    }
}