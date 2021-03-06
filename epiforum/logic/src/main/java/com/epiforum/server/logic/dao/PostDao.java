package com.epiforum.server.logic.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epiforum.server.data.entity.Post;
import com.epiforum.server.data.entity.Topic;

@Stateless
public class PostDao {

	@PersistenceContext(unitName="epiforum")
	protected EntityManager		em;
	
	public Post					getPost(Integer postId) {
		return this.em.find(Post.class, postId);
	}
	
	public void					savePost(Post post) {
		this.em.persist(post);
	}
	
	/*NEVER USE IT*/
	public void					deletePost(Post post) {
		this.em.remove(post);
	}
	
	@SuppressWarnings("unchecked")
	public List<Post>			getAllPostNotDeleted(Integer topicId, Integer startIndex) {
		Query query = em.createNamedQuery("Post.getAllPostNotDeleted");
		query.setMaxResults(5);
		query.setFirstResult(startIndex);
		query.setParameter("topicId", topicId);
		List<Post> posts = (List<Post>) query.getResultList();
		return posts;
	}

	public Integer				countPosts() {
		Query query = em.createNamedQuery("Post.countAll");
		return ((Long)query.getSingleResult()).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<Topic>			getTopicsFromTag(String tag) {
		Query query = em.createNamedQuery("Post.getTopicsFromTag");
		query.setParameter("search", "%" + "#" + tag + "%");
		List<Topic> topics = (List<Topic>) query.getResultList();
		return topics;
	}
}