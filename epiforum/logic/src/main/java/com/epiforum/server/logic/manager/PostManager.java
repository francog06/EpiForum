package com.epiforum.server.logic.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epiforum.common.ro.PostRO;
import com.epiforum.server.data.entity.Post;
import com.epiforum.server.data.entity.Profile;
import com.epiforum.server.data.entity.Topic;
import com.epiforum.server.logic.dao.PostDao;

@Stateless
public class PostManager {

	@EJB
	private PostDao			postDao;

	public Post				getPostFromId(Integer postId) {
		return this.postDao.getPost(postId);
	}

	public Post				createPost(PostRO postRo, Topic topic, Profile profile) {
		Post post = new Post(topic, profile);
		if (postRo.getTags() != null && !postRo.getTags().isEmpty()) {
			String tag = "";
			for (String elem : postRo.getTags()) {
				elem = elem.replaceAll("[^a-zA-Z]", "");
				if (!elem.trim().isEmpty()) {
					tag += "#"+ elem;
				}
			}
			post.setTag(tag);
		}
		this.postDao.savePost(post);
		return post;
	}
	
	public List<Post>		getAllPostNotDeleted(Integer topicId, Integer startIndex) {
		return this.postDao.getAllPostNotDeleted(topicId, startIndex);
	}
	
	/*NEVER USE IT*/
	public void				deletePost(Post post) {
		this.postDao.deletePost(post);
	}
	
	public boolean			removePost(Post post) {
		if (post.isDeleted() == false) {
			post.setDeleted(true);
			return true;
		}
		return false;
	}

	public Integer 			countPosts() {
		return this.postDao.countPosts();
	}

	public List<Topic>			getTopicsFromTag(String tag) {
		return this.postDao.getTopicsFromTag(tag);
	}
}