package com.epiforum.server.web.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epiforum.common.ro.ChangeInfo;
import com.epiforum.common.ro.MemberRO;
import com.epiforum.common.ro.MyLightProfileRO;
import com.epiforum.common.ro.MyProfileRO;
import com.epiforum.common.ro.TopTopicRO;
import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.logic.exception.BadParametersException;
import com.epiforum.server.logic.exception.TechnicalException;
import com.epiforum.server.web.beanresource.OperationResource;
import com.google.i18n.phonenumbers.NumberParseException;

/**
 * Servlet implementation class Account
 */
@WebServlet("/myaccount")
public class Account extends OperationResource {

	private static final long serialVersionUID = 2053969193294360700L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Account() {
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

			try {
				MyProfileRO profile = this.operationFacade.viewProfile(request, token, myPro.getNickname());
				request.setAttribute("profile", profile);
			} catch (BadCredentialException e) {
				e.printStackTrace();
			} catch (BadParametersException e) {
				e.printStackTrace();
			}

			String url = "/account.jsp";
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
			Boolean success = false;
			/* CHANGE EMAIL */
			if (request.getParameter("EditAccountEmail") != null && request.getParameter("email") != null && request.getParameter("newemail") != null) {
				ChangeInfo inf = new ChangeInfo();
				inf.setEmail(request.getParameter("hemail").trim());
				inf.setOldInfo(request.getParameter("email").trim());
				inf.setNewInfo(request.getParameter("newemail").trim());
				try {
					success = this.operationFacade.changeEmail(request, token, inf);
				} catch (BadCredentialException e) {
					e.printStackTrace();
				}
			}
			
			/* CHANGE PASSWORD */
			if (request.getParameter("EditAccountMdp") != null && request.getParameter("pass") != null && request.getParameter("newpass") != null) {
				ChangeInfo inf = new ChangeInfo();
				inf.setEmail(request.getParameter("hemail").trim());
				inf.setOldInfo(request.getParameter("pass").trim());
				inf.setNewInfo(request.getParameter("newpass").trim());
				try {
					success = this.operationFacade.changePassword(request, token, inf);
				} catch (BadCredentialException e) {
					e.printStackTrace();
				} catch (TechnicalException e) {
					e.printStackTrace();
				}
			}
			
			/* CHANGE ALL */
			if (request.getParameter("EditAccountAll") != null) {
				MyProfileRO myPro = new MyProfileRO();
				myPro.setFirstname(request.getParameter("prenom") != null ? request.getParameter("prenom").trim() : "");
				myPro.setLastname(request.getParameter("nom") != null ? request.getParameter("nom").trim() : "");
				myPro.setNickname(request.getParameter("pseudo") != null ? request.getParameter("pseudo").trim() : "");
				try {
					if (request.getParameter("anniv") != null && !request.getParameter("anniv").trim().isEmpty()) {
						SimpleDateFormat formater = new SimpleDateFormat("yyy-MM-dd", Locale.FRENCH);
						myPro.setBirthdate(formater.parse(request.getParameter("anniv").trim()));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
				myPro.setPhone(request.getParameter("telephone") != null ? request.getParameter("telephone").trim() : "");
				myPro.setFacebookPage(request.getParameter("facebook") != null ? request.getParameter("facebook").trim() : "");
				myPro.setTwitterPage(request.getParameter("twitter") != null ? request.getParameter("twitter").trim() : "");
				myPro.setSkypeContact(request.getParameter("skype") != null ? request.getParameter("skype").trim() : "");
				if (request.getParameter("genre_femme") != null) {
					myPro.setGender(false);
				} else if (request.getParameter("genre_homme") != null){
					myPro.setGender(true);
				}
				myPro.setCity(request.getParameter("ville") != null ? request.getParameter("ville").trim() : "");
				myPro.setDescription(request.getParameter("description") != null ? request.getParameter("description").trim() : "");
				myPro.setSignature(request.getParameter("signature") != null ? request.getParameter("signature").trim() : "");
				try {
					success = this.operationFacade.updateMyProfile(request, token, myPro);
					response.sendRedirect("/web/home");
				} catch (BadCredentialException e) {
					e.printStackTrace();
				} catch (TechnicalException e) {
					e.printStackTrace();
				} catch (BadParametersException e) {
					e.printStackTrace();
				} catch (NumberParseException e) {
					e.printStackTrace();
				}
			}
		}
	}
}