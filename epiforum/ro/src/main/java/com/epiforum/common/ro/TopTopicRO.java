package com.epiforum.common.ro;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TopTopicRO {

	private Integer			id;

	private String			title;

	private Integer			nbPost;

	/**
	 * @return the topicId
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param topicId the topicId to set
	 */
	public void setId(Integer topicId) {
		this.id = topicId;
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