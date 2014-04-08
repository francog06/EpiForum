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

import com.epiforum.common.ro.BoardRO;
import com.epiforum.common.ro.ContentRO;
import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.logic.exception.BadParametersException;
import com.epiforum.server.web.beanresource.AdminResource;

/**
 * Servlet implementation class Board
 */
@WebServlet("/admin/board")
public class Board extends AdminResource {

	private static final long serialVersionUID = 5808655906469138495L;

	/**
     * Default constructor. 
     */
    public Board() {
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

			try {
				List<ContentRO> boards = this.adminFacade.getAllBoards(request, token);
				request.setAttribute("boards", boards);
			} catch (BadCredentialException e) {
				e.printStackTrace();
			}

			String url = "/admin/board.jsp";
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
				Integer catId = Integer.parseInt(request.getParameter("categoryId"));
				BoardRO board = new BoardRO();
				board.setId(catId);
				board.setTitle(request.getParameter("title").trim());
				if (request.getParameter("description") != null) {
					board.setDescription(request.getParameter("description").trim());
				}
				try {
					this.adminFacade.createBoard(request, token, board);
					response.sendRedirect("home");
				} catch (BadCredentialException e) {
					e.printStackTrace();
				} catch (BadParametersException e) {
					e.printStackTrace();
				}
			}

			/*UPDATE*/
			if (request.getParameter("update") != null && request.getParameter("title") != null) {
				Integer boardId = Integer.parseInt(request.getParameter("boardId"));
				BoardRO board = new BoardRO();
				board.setId(boardId);
				board.setTitle(request.getParameter("title").trim());
				if (request.getParameter("description") != null) {
					board.setDescription(request.getParameter("description").trim());
				}
				try {
					this.adminFacade.updateBoard(request, token, board);
					response.sendRedirect("home");
				} catch (BadCredentialException e) {
					e.printStackTrace();
				} catch (BadParametersException e) {
					e.printStackTrace();
				}
			}

			/*UPDATE*/
			if (request.getParameter("delete") != null) {
				Integer boardId = Integer.parseInt(request.getParameter("boardId"));

				try {
					this.adminFacade.deleteBoard(request, token, boardId);
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
