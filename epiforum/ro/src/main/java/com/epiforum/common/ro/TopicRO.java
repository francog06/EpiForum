package com.epiforum.common.ro;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TopicRO {

	private Integer					id;

	private Integer					topicId;

	private Date					modified;

	private String					title;

	private String					description;

	private Boolean					locked;

	private List<PostRO>			posts;

	private PostRO					post;
	
	private Integer					nbPost;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the topicId
	 */
	public Integer getTopicId() {
		return topicId;
	}

	/**
	 * @param topicId the topicId to set
	 */
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	/**
	 * @return the modified
	 */
	public Date getModified() {
		return modified;
	}

	/**
	 * @param modified the modified to set
	 */
	public void setModified(Date modified) {
		this.modified = modified;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the locked
	 */
	public Boolean getLocked() {
		return locked;
	}

	/**
	 * @param locked the locked to set
	 */
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	/**
	 * @return the posts
	 */
	public List<PostRO> getPosts() {
		return posts;
	}

	/**
	 * @param posts the posts to set
	 */
	public void setPosts(List<PostRO> posts) {
		this.posts = posts;
	}

	/**
	 * @return the post
	 */
	public PostRO getPost() {
		return post;
	}

	/**
	 * @param post the post to set
	 */
	public void setPost(PostRO post) {
		this.post = post;
	}

	/**
	 * @return the nbPost
	 */
	public Integer getNbPost() {
		return nbPost;
	}

	/**
	 * @param nbPost the nbPost to set
	 */
	public void setNbPost(Integer nbPost) {
		this.nbPost = nbPost;
	}
}