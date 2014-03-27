package com.epiforum.common.ro;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TopicRO {

	private int						id;

	private String					title;

	private String					description;

	private boolean					locked;

	private List<PostRO>			posts;

	private List<LightProfileRO> 	profiles;

	private PostRO					post;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	public boolean getLocked() {
		return locked;
	}

	/**
	 * @param locked the locked to set
	 */
	public void setLocked(boolean locked) {
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
	 * @return the profiles
	 */
	public List<LightProfileRO> getProfiles() {
		return profiles;
	}

	/**
	 * @param profiles the profiles to set
	 */
	public void setProfiles(List<LightProfileRO> profiles) {
		this.profiles = profiles;
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
}