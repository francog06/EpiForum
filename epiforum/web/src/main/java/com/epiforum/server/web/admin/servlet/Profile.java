package com.epiforum.server.web.admin.servlet;

import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.logic.exception.BadParametersException;
import com.epiforum.server.web.beanresource.AdminResource;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/admin/profile")
public class Profile extends AdminResource {

	private static final long serialVersionUID = -448581992583934988L;

	/**
     * Default constructor. 
     */
    public Profile() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession(false);
		request.setCharacterEncoding("UTF-8");
		if (se == null || se.getAttribute("Authorization") == null) {
			response.sendRedirect("login");
		} else {
			String token = (String) se.getAttribute("Authorization");
			
			try {
				List<String> pros = this.adminFacade.getAllActiveProfiles(request, token);
				request.setAttribute("pros", pros);
			} catch (BadCredentialException e) {
				e.printStackTrace();
			}
			String url = "/admin/profile.jsp";
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
			String nickname = request.getParameter("nickname");
			try {
				this.adminFacade.banMember(request, token, nickname);
				response.sendRedirect("home");
			} catch (BadCredentialException e) {
				e.printStackTrace();
			} catch (BadParametersException e) {
				e.printStackTrace();
			}
		}
	}
}