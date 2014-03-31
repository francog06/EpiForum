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
		HttpSession se = request.getSession(false);
		String token = null;
		//MyLightProfileRO myPro = null;
		if (se != null) {
			/*try {
				myPro = this.operationFacade.getMyLightProfileRO(request, token);
			} catch (BadCredentialException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BadParametersException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			token = (String) se.getAttribute("Authorization");
	    	request.setAttribute("Authorization", token);
	    }
		/*Integer nbMembers = this.operationFacade.numberOfMembers();
		Integer nbTopics = this.operationFacade.numberOfTopics();
		Integer nbPosts = this.operationFacade.numberOfPosts();
		List<CategoryRO> cats = this.operationFacade.viewAllCategories(request, token);
		List<MemberRO> connectedMembers = this.operationFacade.connectedProfiles();
		List<MemberRO> birthdayMembers = this.operationFacade.birthdayProfiles();
		List<MemberRO> topMembers = this.operationFacade.topProfiles();*/
		String url="/home.jsp";
	    ServletContext sc = getServletContext();
	    RequestDispatcher rd = sc.getRequestDispatcher(url);
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}