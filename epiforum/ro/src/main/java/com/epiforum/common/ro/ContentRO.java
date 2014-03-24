package com.epiforum.common.ro;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ContentRO {

	protected String		content;
	
	protected int			postId;

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
	 * @return the postId
	 */
	public Integer getPostId() {
		return postId;
	}

	/**
	 * @param postId the postId to set
	 */
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
}