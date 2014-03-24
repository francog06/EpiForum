package com.epiforum.server.logic.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
