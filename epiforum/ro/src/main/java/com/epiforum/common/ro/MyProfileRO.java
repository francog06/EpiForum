package com.epiforum.common.ro;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyProfileRO extends ProfileInfoRO {

	private Integer			id;
	
	private String			nickname;

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
}
