package com.epiforum.server.web.admin.servlet;

import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.web.beanresource.AdminResource;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLogout
 */
@WebServlet("/admin/logout")
public class Logout extends AdminResource {

	private static final long serialVersionUID = -2609187868003295365L;

	/**
     * Default constructor. 
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
		    	this.adminFacade.logout(token);
			} catch (BadCredentialException e) {
				e.printStackTrace();
			}
		    se.invalidate();
		}
		response.sendRedirect("login");
	}
}