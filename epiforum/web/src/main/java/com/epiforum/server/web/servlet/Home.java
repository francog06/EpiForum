package com.epiforum.server.web.servlet;

import java.io.IOException;
import java.text.ParseException;
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
import com.epiforum.common.ro.MemberRO;
import com.epiforum.common.ro.MyLightProfileRO;
import com.epiforum.common.ro.TopTopicRO;
import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.logic.exception.BadParametersException;
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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession(false);
		request.setCharacterEncoding("UTF-8");
		String token = null;
		if (se != null) {
			token = (String) se.getAttribute("Authorization");
	    	request.setAttribute("Authorization", token);
	    }
		/* CATEGORIES */
		List<CategoryRO> cats = null;
		try {
			cats = this.operationFacade.viewAllCategories(request, token);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (cats != null) {
			request.setAttribute("cats", cats);
		}
		/* STATS */
		Integer nbMembers = this.operationFacade.numberOfMembers();
		request.setAttribute("nbMembers", nbMembers);
		Integer nbTopics = this.operationFacade.numberOfTopics();
		request.setAttribute("nbTopics", nbTopics);
		Integer nbPosts = this.operationFacade.numberOfPosts();
		request.setAttribute("nbPosts", nbPosts);
		List<MemberRO> connectedMembers = this.operationFacade.connectedProfiles();
		request.setAttribute("connectedMembers", connectedMembers);
		Integer cMemberSize = connectedMembers == null ? 0 : connectedMembers.size();
		request.setAttribute("cMemberSize", cMemberSize);
		List<MemberRO> birthdayMembers = this.operationFacade.birthdayProfiles();
		request.setAttribute("birthdayMembers", birthdayMembers);

		/* SIDEBAR */
		MyLightProfileRO myPro = null;
		if (token != null) {
			try {
				myPro = this.operationFacade.getMyLightProfileRO(request, token);
				request.setAttribute("myPro", myPro);
			} catch (BadCredentialException e) {
				e.printStackTrace();
			} catch (BadParametersException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		List<MemberRO> topMembers = this.operationFacade.topProfiles();
		request.setAttribute("topMembers", topMembers);
		List<TopTopicRO> topTopics = this.operationFacade.topTopics();
		request.setAttribute("topTopics", topTopics);

		String url="/home.jsp";
	    ServletContext sc = getServletContext();
	    RequestDispatcher rd = sc.getRequestDispatcher(url);
	    rd.forward(request, response);
	}
}