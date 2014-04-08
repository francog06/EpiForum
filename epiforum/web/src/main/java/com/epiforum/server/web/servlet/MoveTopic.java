package com.epiforum.server.web.servlet;

import com.epiforum.common.ro.ContentRO;
import com.epiforum.common.ro.MemberRO;
import com.epiforum.common.ro.MyLightProfileRO;
import com.epiforum.common.ro.TopTopicRO;
import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.logic.exception.BadParametersException;
import com.epiforum.server.web.beanresource.ModerationResource;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MoveTopic
 */
@WebServlet("/movetopic")
public class MoveTopic extends ModerationResource {

	private static final long serialVersionUID = -5260784252359501111L;

	/**
     * Default constructor. 
     */
    public MoveTopic() {
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
			Integer topicId = Integer.parseInt(request.getParameter("tid"));
			if (topicId == null || topicId == 0) {
				throw new ServletException("Une erreur est survenue.");
			}

			/* STATS */
			Integer nbMembers = this.moderationFacade.numberOfMembers();
			request.setAttribute("nbMembers", nbMembers);
			Integer nbTopics = this.moderationFacade.numberOfTopics();
			request.setAttribute("nbTopics", nbTopics);
			Integer nbPosts = this.moderationFacade.numberOfPosts();
			request.setAttribute("nbPosts", nbPosts);
			List<MemberRO> connectedMembers = this.moderationFacade.connectedProfiles();
			request.setAttribute("connectedMembers", connectedMembers);
			Integer cMemberSize = connectedMembers == null ? 0 : connectedMembers.size();
			request.setAttribute("cMemberSize", cMemberSize);
			List<MemberRO> birthdayMembers = this.moderationFacade.birthdayProfiles();
			request.setAttribute("birthdayMembers", birthdayMembers);

			/* SIDEBAR */
			MyLightProfileRO myPro = null;
			try {
				myPro = this.moderationFacade.getMyLightProfileRO(request, token);
				request.setAttribute("myPro", myPro);
			} catch (BadCredentialException e) {
				e.printStackTrace();
			} catch (BadParametersException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			List<MemberRO> topMembers = this.moderationFacade.topProfiles();
			request.setAttribute("topMembers", topMembers);
			List<TopTopicRO> topTopics = this.moderationFacade.topTopics();
			request.setAttribute("topTopics", topTopics);
			List<ContentRO> boards = null;
			try {
				boards = this.moderationFacade.getAllBoardsFromSameCategory(request, token, topicId);
				request.setAttribute("topicId", topicId);
				request.setAttribute("boards", boards);
			} catch (BadCredentialException e) {
				e.printStackTrace();
			} catch (BadParametersException e) {
				e.printStackTrace();
			}
			
			String url = "/moveTopic.jsp";
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
			Integer topicId = Integer.parseInt(request.getParameter("topicId"));
			Integer boardId = Integer.parseInt(request.getParameter("boardId"));

			try {
				this.moderationFacade.moveTopic(request, token, topicId, boardId);
				response.sendRedirect("home");
			} catch (BadCredentialException e) {
				e.printStackTrace();
			} catch (BadParametersException e) {
				e.printStackTrace();
			}
		}
	}
}