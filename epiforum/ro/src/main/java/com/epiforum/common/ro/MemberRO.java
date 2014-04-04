package com.epiforum.common.ro;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MemberRO {

	protected String			nickname;

	protected Integer			nbThank;

	protected Integer			type;

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
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}
}