package com.epiforum.server.logic.manager;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epiforum.server.logic.dao.CategoryDao;

@Stateless
public class CategoryManager {

	@EJB
	private CategoryDao			categoryDao;
}
