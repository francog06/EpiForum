package com.epiforum.server.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epiforum.common.ro.AccountRO;
import com.epiforum.server.web.beanresource.OperationResource;

/**
 * Servlet implementation class Course
 */
@WebServlet("/home")
public class Home extends OperationResource {

	private static final long serialVersionUID = 8486325797393527981L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//List<CourseRO> coRos = this.operationFacade.getAllCourses();
		String url="/home.jsp";
	    ServletContext sc = getServletContext();
	    RequestDispatcher rd = sc.getRequestDispatcher(url);
	    HttpSession session = request.getSession();
	    AccountRO acr = (AccountRO)session.getAttribute("acr");
	    if (acr != null) {
	    	//request.setAttribute("token", acr.getToken());
	    }
	    //request.setAttribute("coRos", coRos);
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
