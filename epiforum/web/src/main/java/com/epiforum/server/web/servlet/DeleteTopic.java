package com.epiforum.server.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.logic.exception.BadParametersException;
import com.epiforum.server.web.beanresource.ModerationResource;

/**
 * Servlet implementation class DeleteTopic
 */
@WebServlet("/deletetopic")
public class DeleteTopic extends ModerationResource {

	private static final long serialVersionUID = -5735677978374836892L;

	/**
     * Default constructor. 
     */
    public DeleteTopic() {
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
			Integer topicId = Integer.parseInt(request.getParameter("tid"));
			if (topicId == null || topicId == 0) {
				throw new ServletException("Une erreur est survenue.");
			}
			try {
				this.moderationFacade.deleteTopic(request, token, topicId);
				response.sendRedirect("home");
			} catch (BadCredentialException e) {
				e.printStackTrace();
			} catch (BadParametersException e) {
				e.printStackTrace();
			}
		}
	}
}