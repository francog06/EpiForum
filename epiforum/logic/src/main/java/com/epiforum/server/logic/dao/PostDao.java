package com.epiforum.server.logic.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epiforum.server.data.entity.Post;
import com.epiforum.server.logic.utils.QueryUtils;

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
	
	public void					deletePost(Post post) {
		this.em.remove(post);
	}
	
	@SuppressWarnings("unchecked")
	public List<Post>			getAllPostNotDeleted(Integer topicId, Integer startIndex) {
		Query query = em.createNamedQuery("Post.getAllPostNotDeleted");
		query.setMaxResults(10);
		query.setFirstResult(startIndex);
		query.setParameter("topicId", topicId);
		List<Post> posts = (List<Post>) query.getResultList();
		return posts;
	}

	public Integer				countPosts() {
		Query query = em.createNamedQuery("Post.countAll");
		return (Integer) QueryUtils.getSingleResultOrNull(query);
	}
}