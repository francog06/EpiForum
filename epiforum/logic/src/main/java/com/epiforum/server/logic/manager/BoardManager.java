package com.epiforum.server.logic.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epiforum.server.data.entity.Board;
import com.epiforum.server.logic.dao.BoardDao;

@Stateless
public class BoardManager {

	@EJB
	private BoardDao			boardDao;

	public Board				getBoardFromId(Integer boardId) {
		return this.boardDao.getBoard(boardId);
	}
	
	//TODO getAllBoards
	public List<Board>			getAllBoards() {
		return null;
	}
}