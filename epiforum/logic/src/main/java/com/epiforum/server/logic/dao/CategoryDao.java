package com.epiforum.server.logic.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epiforum.server.data.entity.Category;

@Stateless
public class CategoryDao {

	@PersistenceContext(unitName="epiforum")
	protected EntityManager		em;
	
	public Category				getCategory(Integer categoryId) {
		return this.em.find(Category.class, categoryId);
	}
	
	public void					saveCategory(Category category) {
		this.em.persist(category);
	}
	
	public void					deleteCategory(Category category) {
		this.em.remove(category);
	}
	
	@SuppressWarnings("unchecked")
	public List<Category>		getAllCategories() {
		Query query = em.createNamedQuery("Category.getAll");
		List<Category> cats = (List<Category>) query.getResultList();
		return cats;
	}
}
