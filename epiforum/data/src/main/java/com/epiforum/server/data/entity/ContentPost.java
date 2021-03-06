package com.epiforum.server.data.entity;

// Generated Mar 20, 2014 8:33:43 PM by Hibernate Tools 4.0.0

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * ContentPost generated by hbm2java
 */
@Entity
@Table(name = "contentPost")
public class ContentPost implements Serializable {

	private static final long serialVersionUID = -5589025369197669863L;

	private Integer			postId;
	private Post			post;
	private String			content;

	public 					ContentPost() {
	}

	public 					ContentPost(Post post, String content) {
		this.postId = post.getId();
		this.post = post;
		this.content = content;
	}

	@Id
	@Column(name = "postId", unique = true, nullable = false)
	public Integer 			getPostId() {
		return this.postId;
	}

	public void 			setPostId(Integer postId) {
		this.postId = postId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Post 			getPost() {
		return this.post;
	}

	public void 			setPost(Post post) {
		this.post = post;
	}

	@Column(name = "content", nullable = false, columnDefinition = "TEXT")
	public String 			getContent() {
		return this.content;
	}

	public void 			setContent(String content) {
		this.content = content;
	}
}