package com.epiforum.common.ro;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PostRO {

	private int				topicId;

	private int				profileId;

	private String			content;

	private List<String>	tags;

	/**
	 * @return the topicId
	 */
	public int getTopicId() {
		return topicId;
	}

	/**
	 * @param topicId the topicId to set
	 */
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	/**
	 * @return the profileId
	 */
	public int getProfileId() {
		return profileId;
	}

	/**
	 * @param profileId the profileId to set
	 */
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the tag
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
