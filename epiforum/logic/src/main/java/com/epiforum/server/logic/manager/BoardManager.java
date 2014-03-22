package com.epiforum.server.logic.manager;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epiforum.server.logic.dao.BoardDao;

@Stateless
public class BoardManager {

	@EJB
	private BoardDao			boardDao;
}
