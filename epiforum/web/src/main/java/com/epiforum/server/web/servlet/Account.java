package com.epiforum.server.web.servlet;

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

import com.epiforum.server.web.beanresource.OperationResource;

/**
 * Servlet implementation class Account
 */
@WebServlet("/account")
public class Account extends OperationResource {

	private static final long serialVersionUID = 2053969193294360700L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Account() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("acr") == null) {
			response.sendRedirect("/home");
		} else {
			String url = "/account.jsp";
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			AccountRO acr = null;
			if (session.getAttribute("acr") != null) {
				acr = (AccountRO) session.getAttribute("acr");
				}
			 if (acr != null) {
				 request.setAttribute("token", acr.getToken());
				 request.setAttribute("acr", acr);
				 List<ExamRO> exams = this.operationFacade.getAllExamsFromAccountId(acr.getId());
				 request.setAttribute("exams", exams);
				 }
			 rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
