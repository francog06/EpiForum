package com.epiforum.common.ro;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LightProfileRO {

	protected String			nickname;

	protected Integer			nbPost;

	protected Integer			nbThank;

	protected Boolean			picture;

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	/**
	 * @return the nbThank
	 */
	public Integer getNbThank() {
		return nbThank;
	}

	/**
	 * @param nbThank the nbThank to set
	 */
	public void setNbThank(Integer nbThank) {
		this.nbThank = nbThank;
	}

	/**
	 * @return the picture
	 */
	public Boolean getPicture() {
		return picture;
	}

	/**
	 * @param picture the picture to set
	 */
	public void setPicture(Boolean picture) {
		this.picture = picture;
	}
}