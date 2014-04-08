package com.epiforum.server.logic.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epiforum.server.data.entity.Board;

@Stateless
public class BoardDao {

	@PersistenceContext(unitName="epiforum")
	protected EntityManager		em;
	
	public Board				getBoard(Integer boardId) {
		return this.em.find(Board.class, boardId);
	}
	
	public void					saveBoard(Board board) {
		this.em.persist(board);
	}
	
	public void					deleteBoard(Board board) {
		this.em.remove(board);
	}

	@SuppressWarnings("unchecked")
	public List<Board>			getAllBoardsFromCategoryId(Integer categoryId) {
		Query query = this.em.createNamedQuery("Board.getAllBoardsFromCategoryId");
		query.setParameter("categoryId", categoryId);
		List<Board> boards = (List<Board>) query.getResultList();
		return boards;
	}

	@SuppressWarnings("unchecked")
	public List<Board>			getAllBoards() {
		Query query = em.createNamedQuery("Board.getAll");
		List<Board> boards = (List<Board>) query.getResultList();
		return boards;
	}
}