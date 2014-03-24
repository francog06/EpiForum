package com.epiforum.server.logic.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.epiforum.server.data.entity.Topic;

@Stateless
public class TopicDao {

	@PersistenceContext(unitName="epiforum")
	protected EntityManager		em;
	
	public Topic				getTopic(Integer topicId) {
		return this.em.find(Topic.class, topicId);
	}
	
	public void					saveTopic(Topic topic) {
		this.em.persist(topic);
	}
	
	public void					deleteTopic(Topic topic) {
		this.em.remove(topic);
	}
}