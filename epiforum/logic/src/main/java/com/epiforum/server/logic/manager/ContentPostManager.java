package com.epiforum.server.logic.manager;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epiforum.server.data.entity.ContentPost;
import com.epiforum.server.data.entity.Post;
import com.epiforum.server.logic.dao.ContentPostDao;

@Stateless
public class ContentPostManager {

	@EJB
	private ContentPostDao		contentPostDao;

	public ContentPost			getContentPostFromId(Integer contentPostId) {
		return this.contentPostDao.getContentPost(contentPostId);
	}

	public ContentPost			createContentPost(String content, Post post) {
		ContentPost contentPost = new ContentPost(post, content.trim());
		this.contentPostDao.saveContentPost(contentPost);
		return contentPost;
	}
	
	public ContentPost			updateContentPost(ContentPost contentPost, String content) {
		contentPost.setContent("EDIT: " + content);
		return contentPost;
	}
}