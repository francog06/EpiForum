package com.epiforum.server.logic.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epiforum.server.data.entity.Category;
import com.epiforum.server.logic.dao.CategoryDao;

@Stateless
public class CategoryManager {

	@EJB
	private CategoryDao			categoryDao;
	
	public Category				getCategoryFromId(Integer categoryId) {
		return this.categoryDao.getCategory(categoryId);
	}
	
	public List<Category>		getAllCategories() {
		return this.categoryDao.getAllCategories();
	}
}
