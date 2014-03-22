package com.epiforum.server.logic.manager;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epiforum.server.logic.dao.PostDao;

@Stateless
public class PostManager {

	@EJB
	private PostDao			postDao;
}
