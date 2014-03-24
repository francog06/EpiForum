package com.epiforum.server.logic.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.epiforum.server.data.entity.ContentPost;

@Stateless
public class ContentPostDao {

	@PersistenceContext(unitName="epiforum")
	protected EntityManager		em;
	
	public ContentPost			getContentPost(Integer contentId) {
		return this.em.find(ContentPost.class, contentId);
	}
	
	public void					saveContentPost(ContentPost content) {
		this.em.persist(content);
	}
	
	public void					deleteContentPost(ContentPost content) {
		this.em.remove(content);
	}
}