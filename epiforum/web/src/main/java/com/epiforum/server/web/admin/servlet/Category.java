package com.epiforum.server.web.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epiforum.common.ro.CategoryRO;
import com.epiforum.common.ro.ContentRO;
import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.logic.exception.BadParametersException;
import com.epiforum.server.web.beanresource.AdminResource;

/**
 * Servlet implementation class Category
 */
@WebServlet("/admin/category")
public class Category extends AdminResource {

	private static final long serialVersionUID = 4657307738182883220L;

	/**
     * Default constructor. 
     */
    public Category() {
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
				List<ContentRO> cats = this.adminFacade.getAllCategories(request, token);
				request.setAttribute("cats", cats);
			} catch (BadCredentialException e) {
				e.printStackTrace();
			}
			
			String url = "/admin/category.jsp";
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

			/*CREATE*/
			if (request.getParameter("create") != null && request.getParameter("title") != null) {
				CategoryRO cat = new CategoryRO();
				cat.setTitle(request.getParameter("title").trim());
				if (request.getParameter("description") != null) {
					cat.setDescription(request.getParameter("description").trim());
				}
				try {
					this.adminFacade.createCategory(request, token, cat);
					response.sendRedirect("home");
				} catch (BadCredentialException e) {
					e.printStackTrace();
				} catch (BadParametersException e) {
					e.printStackTrace();
				}
			}

			/*UPDATE*/
			if (request.getParameter("update") != null && request.getParameter("title") != null) {
				Integer categoryId = Integer.parseInt(request.getParameter("categoryId"));
				CategoryRO cat = new CategoryRO();
				cat.setId(categoryId);
				cat.setTitle(request.getParameter("title").trim());
				if (request.getParameter("description") != null) {
					cat.setDescription(request.getParameter("description").trim());
				}
				try {
					this.adminFacade.updateCategory(request, token, cat);
					response.sendRedirect("home");
				} catch (BadCredentialException e) {
					e.printStackTrace();
				} catch (BadParametersException e) {
					e.printStackTrace();
				}
			}

			/*UPDATE*/
			if (request.getParameter("delete") != null) {
				Integer categoryId = Integer.parseInt(request.getParameter("categoryId"));

				try {
					this.adminFacade.deleteCategory(request, token, categoryId);
					response.sendRedirect("home");
				} catch (BadCredentialException e) {
					e.printStackTrace();
				} catch (BadParametersException e) {
					e.printStackTrace();
				}
			}
		}
	}
}