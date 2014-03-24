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

	public ContentPost			createContentPost(String content, Post post) {
		ContentPost contentPost = new ContentPost(post, content.trim());
		return contentPost;
	}
}