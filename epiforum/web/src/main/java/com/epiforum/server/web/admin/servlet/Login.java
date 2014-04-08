package com.epiforum.server.web.admin.servlet;

import com.epiforum.common.ro.LoginRO;
import com.epiforum.server.data.entity.Account.Type;
import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.logic.exception.TechnicalException;
import com.epiforum.server.web.beanresource.AdminResource;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/admin/login")
public class Login extends AdminResource {

	private static final long serialVersionUID = -4148951242166120260L;

	/**
     * Default constructor. 
     */
    public Login() {
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession(false);
		request.setCharacterEncoding("UTF-8");
		if (se == null || se.getAttribute("Authorization") == null) {
			String url="/admin/login.jsp";
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
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String token = (String) session.getAttribute("Authorization");
		LoginRO log = new LoginRO();
		log.setEmail(request.getParameter("email"));
		log.setPassword(request.getParameter("password"));
		try {
			token = this.adminFacade.login(request, token, log, Type.ADMIN);
			session.setAttribute("Authorization", token);
			response.sendRedirect("home");
		} catch (TechnicalException e) {
			e.printStackTrace();
		} catch (BadCredentialException e) {
			e.printStackTrace();
		}
	}
}