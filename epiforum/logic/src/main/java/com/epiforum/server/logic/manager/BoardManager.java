package com.epiforum.server.logic.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epiforum.common.ro.BoardRO;
import com.epiforum.server.data.entity.Board;
import com.epiforum.server.logic.dao.BoardDao;

@Stateless
public class BoardManager {

	@EJB
	private BoardDao			boardDao;

	public Board				getBoardFromId(Integer boardId) {
		return this.boardDao.getBoard(boardId);
	}
	
	public List<Board>			getAllBoardsFromCategoryId(Integer categoryId) {
		return this.boardDao.getAllBoardsFromCategoryId(categoryId);
	}
	
	public void					deleteBoard(Board board) {
		this.boardDao.deleteBoard(board);
	}

	public void					createBoard(Board bo) {
		this.boardDao.saveBoard(bo);		
	}

	public Boolean				updateBoard(Board board, BoardRO bo) {
		Boolean modified = false;
		if (bo.getTitle() != null && !bo.getTitle().trim().isEmpty()) {
			board.setTitle(bo.getTitle().trim());
			modified = true;
		}
		if (bo.getDescription() != null && !bo.getDescription().trim().isEmpty()) {
			board.setDescription(bo.getDescription().trim());
			modified = true;
		}
		return modified;
	}

	public List<Board>			getAllBoards() {
		return this.boardDao.getAllBoards();
	}
}