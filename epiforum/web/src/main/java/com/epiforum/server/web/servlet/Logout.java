package com.epiforum.server.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		AccountRO acr = (AccountRO)session.getAttribute("acr");
	    if (acr != null) {
	    	TokenRO token = new TokenRO();
		    token.setToken(acr.getToken());
		    this.operationFacade.logout(token);
		    System.out.println(acr.getEmail() + " logged out!");
		    session.invalidate();
		    }
	    response.sendRedirect("/web/Home");
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
