package com.epiforum.common.ro;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TopTopicRO {

	private int			id;

	private String		title;

	private int			nbPost;

	/**
	 * @return the topicId
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param topicId the topicId to set
	 */
	public void setId(int topicId) {
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
	public int getNbPost() {
		return nbPost;
	}

	/**
	 * @param nbPost the nbPost to set
	 */
	public void setNbPost(int nbPost) {
		this.nbPost = nbPost;
	}
}