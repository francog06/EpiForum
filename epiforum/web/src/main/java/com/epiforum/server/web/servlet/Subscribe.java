package com.epiforum.server.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epiforum.common.ro.SignupRO;
import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.logic.exception.BadParametersException;
import com.epiforum.server.logic.exception.TechnicalException;
import com.epiforum.server.web.beanresource.OperationResource;

/**
 * Servlet implementation class Subscribe
 */
@WebServlet("/subscribe")
public class Subscribe extends OperationResource {

	private static final long serialVersionUID = 507533019398198137L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Subscribe() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url="/subscribe.jsp";
	    ServletContext sc = getServletContext();
	    RequestDispatcher rd = sc.getRequestDispatcher(url);
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		SignupRO sign = new SignupRO();
		sign.setEmail(request.getParameter("email"));
		sign.setNickname(request.getParameter("nickname"));
		sign.setFirstname(request.getParameter("firstname"));
		sign.setLastname(request.getParameter("lastname"));
		sign.setPassword(request.getParameter("password"));
		try {
			this.operationFacade.subscribe(request, sign);
			response.sendRedirect("/web/login");
		} catch (BadCredentialException e) {
			String url="/subscribe.jsp";
		    ServletContext sc = getServletContext();
		    RequestDispatcher rd = sc.getRequestDispatcher(url);
		    request.setAttribute("error", e.getMessage());
		    rd.forward(request, response);
			e.printStackTrace();
		} catch (TechnicalException e) {
			String url="/subscribe.jsp";
		    ServletContext sc = getServletContext();
		    RequestDispatcher rd = sc.getRequestDispatcher(url);
		    request.setAttribute("error", e.getMessage());
		    rd.forward(request, response);
			e.printStackTrace();
		} catch (BadParametersException e) {
			String url="/subscribe.jsp";
		    ServletContext sc = getServletContext();
		    RequestDispatcher rd = sc.getRequestDispatcher(url);
		    request.setAttribute("error", e.getMessage());
		    rd.forward(request, response);
			e.printStackTrace();
		}
	}
}