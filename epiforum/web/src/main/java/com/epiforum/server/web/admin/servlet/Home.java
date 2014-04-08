package com.epiforum.server.web.admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epiforum.server.web.beanresource.AdminResource;

/**
 * Servlet implementation class home
 */
@WebServlet("/admin/home")
public class Home extends AdminResource {

	private static final long serialVersionUID = 8560854450435332915L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
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
			String url = "/admin/home.jsp";
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			rd.forward(request, response);
		}
	}
}