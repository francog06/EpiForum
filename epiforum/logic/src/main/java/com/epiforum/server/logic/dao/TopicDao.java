package com.epiforum.server.logic.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	public Integer				countTopics() {
		Query query = em.createNamedQuery("Topic.countAll");
		return ((Long)query.getSingleResult()).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<Topic>			getTopTopics(Integer number) {
		Query query = em.createNamedQuery("Topic.getTopTopics");
		query.setMaxResults(number);
		List<Topic> topics = query.getResultList();
		return topics;
	}
}