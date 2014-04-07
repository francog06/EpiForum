package com.epiforum.server.web.servlet;

import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.logic.exception.BadParametersException;
import com.epiforum.server.logic.exception.TechnicalException;
import com.epiforum.server.web.beanresource.OperationResource;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ThankProfile
 */
@WebServlet("/thankprofile")
public class ThankProfile extends OperationResource {

	private static final long serialVersionUID = -6104635308173883678L;

	/**
     * Default constructor. 
     */
    public ThankProfile() {
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
			String token = (String) se.getAttribute("Authorization");
			request.setAttribute("Authorization", token);

			String nickname = (String) request.getParameter("nick");
			Integer topicId = Integer.parseInt(request.getParameter("tid"));
			if (nickname == null || nickname.trim().isEmpty() || topicId == null || topicId == 0) {
				throw new ServletException("Une erreur est survenue.");
			}

			try {
				this.operationFacade.thankProfile(request, token, nickname);
				response.sendRedirect("topic?id=" + topicId + "&page=1");
			} catch (BadCredentialException e) {
				e.printStackTrace();
			} catch (TechnicalException e) {
				e.printStackTrace();
			} catch (BadParametersException e) {
				e.printStackTrace();
			}
		}
	}
}