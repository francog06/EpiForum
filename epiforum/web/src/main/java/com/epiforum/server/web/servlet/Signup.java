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
 * Servlet implementation class Signup
 */
@WebServlet("/signup")
public class Signup extends OperationResource {

	private static final long serialVersionUID = 507533019398198137L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/signup.jsp";
	    ServletContext sc = getServletContext();
	    RequestDispatcher rd = sc.getRequestDispatcher(url);
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SignupRO sign = new SignupRO();
		sign.setEmail(request.getParameter("email"));
		sign.setFirstname(request.getParameter("firstname"));
		sign.setLastname(request.getParameter("lastname"));
		sign.setPassword(request.getParameter("password"));
		try {
			this.operationFacade.signup(sign);
			response.sendRedirect("/web/Login");
		} catch (BadCredentialException e) {
			String url="/signup.jsp";
		    ServletContext sc = getServletContext();
		    RequestDispatcher rd = sc.getRequestDispatcher(url);
		    request.setAttribute("error", true);
		    response.setHeader("Cache-Control", "max-age=604800");
		    rd.forward(request, response);
			e.printStackTrace();
		} catch (TechnicalException e) {
			String url="/signup.jsp";
		    ServletContext sc = getServletContext();
		    RequestDispatcher rd = sc.getRequestDispatcher(url);
		    request.setAttribute("error", true);
		    response.setHeader("Cache-Control", "max-age=604800");
		    rd.forward(request, response);
			e.printStackTrace();
		} catch (BadParametersException e) {
			String url="/signup.jsp";
		    ServletContext sc = getServletContext();
		    RequestDispatcher rd = sc.getRequestDispatcher(url);
		    request.setAttribute("error", true);
		    response.setHeader("Cache-Control", "max-age=604800");
		    rd.forward(request, response);
			e.printStackTrace();
		}
	}

}
