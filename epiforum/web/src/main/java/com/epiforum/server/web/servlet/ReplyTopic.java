package com.epiforum.server.web.servlet;

import com.epiforum.common.ro.MemberRO;
import com.epiforum.common.ro.MyLightProfileRO;
import com.epiforum.common.ro.PostRO;
import com.epiforum.common.ro.TopTopicRO;
import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.logic.exception.BadParametersException;
import com.epiforum.server.logic.exception.TechnicalException;
import com.epiforum.server.web.beanresource.OperationResource;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReplyTopic
 */
@WebServlet("/replytopic")
public class ReplyTopic extends OperationResource {

	private static final long serialVersionUID = 7228304377523452099L;

	/**
     * Default constructor. 
     */
    public ReplyTopic() {
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
			request.setAttribute("Authorization", token);
			Integer topicId = Integer.parseInt(request.getParameter("tid"));
			if (topicId == null || topicId == 0) {
				throw new ServletException("Une erreur est survenue.");
			}
			request.setAttribute("topicId", topicId);

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
			List<MemberRO> topMembers = this.operationFacade.topProfiles();
			request.setAttribute("topMembers", topMembers);
			List<TopTopicRO> topTopics = this.operationFacade.topTopics();
			request.setAttribute("topTopics", topTopics);
			
			String url = "/replyTopic.jsp";
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
			if (request.getParameter("message") != null && request.getParameter("topicId") != null) {
				PostRO post = new PostRO();
				post.setTopicId(Integer.parseInt(request.getParameter("topicId")));
				post.setContent(request.getParameter("message"));
				List<String> tags = new ArrayList<String>();
				if (request.getParameter("tag_one") != null && !request.getParameter("tag_one").trim().isEmpty()) {
					tags.add(request.getParameter("tag_one").trim());
				}
				if (request.getParameter("tag_two") != null && !request.getParameter("tag_two").trim().isEmpty()) {
					tags.add(request.getParameter("tag_two").trim());
				}
				if (request.getParameter("tag_three") != null && !request.getParameter("tag_three").trim().isEmpty()) {
					tags.add(request.getParameter("tag_three").trim());
				}
				post.setTags(tags);
				try {
					this.operationFacade.addPost(request, token, post);
					response.sendRedirect("topic?id=" + request.getParameter("topicId") + "&page=1");
				} catch (BadCredentialException e) {
					e.printStackTrace();
				} catch (TechnicalException e) {
					e.printStackTrace();
				} catch (BadParametersException e) {
					e.printStackTrace();
				}
			}
		}
	}
}