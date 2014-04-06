package com.epiforum.server.web.servlet;

import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.logic.exception.BadParametersException;
import com.epiforum.server.logic.exception.TechnicalException;
import com.epiforum.server.web.beanresource.OperationResource;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/forgotpassword")
public class ForgotPassword extends OperationResource {

	private static final long serialVersionUID = -7852694120834042150L;

	/**
     * Default constructor. 
     */
    public ForgotPassword() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession(false);
		request.setCharacterEncoding("UTF-8");
		if (se == null || se.getAttribute("Authorization") == null) {
			String url="/forgotPassword.jsp";
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request, response);
		} else {
			response.sendRedirect("home");
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		try {
			this.operationFacade.forgotPassword(request, email);
			response.sendRedirect("login");
		} catch (TechnicalException e) {
			e.printStackTrace();
		} catch (BadParametersException e) {
			e.printStackTrace();
		} catch (BadCredentialException e) {
			e.printStackTrace();
		}
	}
}