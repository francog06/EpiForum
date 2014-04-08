package com.epiforum.server.logic.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epiforum.common.ro.CategoryRO;
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

	public void					createCategory(Category cat) {
		this.categoryDao.saveCategory(cat);
	}

	public Boolean				updateCategory(Category cat, CategoryRO category) {
		boolean modified = false;
		if (category.getTitle() != null && !category.getTitle().trim().isEmpty()) {
			cat.setTitle(category.getTitle().trim());
			modified = true;
		}
		if (category.getDescription() != null && !category.getDescription().trim().isEmpty()) {
			cat.setDescription(category.getDescription().trim());
			modified = true;
		}
		return modified;
	}

	public void					deleteCategory(Category cat) {
		this.categoryDao.deleteCategory(cat);		
	}
}