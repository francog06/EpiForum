package com.epiforum.server.web.servlet;

import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.logic.exception.BadParametersException;
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
 * Servlet implementation class Unsubscribe
 */
@WebServlet("/unsubscribe")
public class Unsubscribe extends OperationResource {

	private static final long serialVersionUID = 5678033049999986277L;

	/**
     * Default constructor. 
     */
    public Unsubscribe() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession(false);
		request.setCharacterEncoding("UTF-8");
		if (se == null || se.getAttribute("Authorization") == null) {
			response.sendRedirect("home");
		} else {
			String url="/unsubscribe.jsp";
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request, response);
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession(false);
		request.setCharacterEncoding("UTF-8");
		if (se == null || se.getAttribute("Authorization") == null) {
			response.sendRedirect("home");
		} else {
			String token = (String) se.getAttribute("Authorization");
			String email = request.getParameter("email");

			try {
				this.operationFacade.unsubscribe(request, token, email);
			} catch (BadCredentialException e) {
				e.printStackTrace();
			} catch (BadParametersException e) {
				e.printStackTrace();
			}
		}
	}
}