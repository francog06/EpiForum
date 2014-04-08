package com.epiforum.server.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epiforum.server.web.beanresource.OperationResource;

/**
 * Servlet implementation class AboutUs
 */
@WebServlet("/aboutus")
public class AboutUs extends OperationResource {

	private static final long serialVersionUID = 5035364178907976814L;

	/**
     * Default constructor. 
     */
    public AboutUs() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url="/aboutus.jsp";
	    ServletContext sc = getServletContext();
	    RequestDispatcher rd = sc.getRequestDispatcher(url);
	    rd.forward(request, response);
	}
}