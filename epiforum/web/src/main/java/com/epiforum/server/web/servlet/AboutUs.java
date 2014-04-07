package com.epiforum.server.web.servlet;

import com.epiforum.server.web.beanresource.OperationResource;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
	}
}