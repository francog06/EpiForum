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
 * Servlet implementation class DeletePost
 */
@WebServlet("/deletepost")
public class DeletePost extends OperationResource {

	private static final long serialVersionUID = 8525542104279948832L;

	/**
     * Default constructor. 
     */
    public DeletePost() {
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
			Integer postId = Integer.parseInt(request.getParameter("pid"));
			if (postId == null || postId == 0) {
				throw new ServletException("Une erreur est survenue.");
			}
			
			try {
				this.operationFacade.removeMyPost(request, token, postId);
				response.sendRedirect("home");
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