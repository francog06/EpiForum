package com.epiforum.server.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epiforum.common.ro.LoginRO;
import com.epiforum.server.data.entity.Account.Type;
import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.logic.exception.TechnicalException;
import com.epiforum.server.web.beanresource.OperationResource;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends OperationResource {

	private static final long serialVersionUID = -3767190736704822106L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession(false);
		if (se == null || se.getAttribute("Authorization") == null) {
			String url="/login.jsp";
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request, response);
		} else {
			response.sendRedirect("/web/home");
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String token = (String) session.getAttribute("Authorization");
		LoginRO log = new LoginRO();
		log.setEmail(request.getParameter("email"));
		log.setPassword(request.getParameter("password"));
		try {
			token = this.operationFacade.login(request, token, log, Type.MEMBRE);
			session.setAttribute("Authorization", token);
			response.sendRedirect("/web");
		} catch (TechnicalException e) {
			String url="/login.jsp";
		    ServletContext sc = getServletContext();
		    RequestDispatcher rd = sc.getRequestDispatcher(url);
		    request.setAttribute("error", true);
		    rd.forward(request, response);
			e.printStackTrace();
		} catch (BadCredentialException e) {
			String url="/login.jsp";
		    ServletContext sc = getServletContext();
		    RequestDispatcher rd = sc.getRequestDispatcher(url);
		    request.setAttribute("error", true);
		    rd.forward(request, response);
			e.printStackTrace();
		}
	}
}