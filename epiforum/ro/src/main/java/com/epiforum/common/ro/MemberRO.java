package com.epiforum.common.ro;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MemberRO {

	private String		nickname;

	private int			nbThank;

	private int			type;

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
	public int getNbThank() {
		return nbThank;
	}

	/**
	 * @param nbThank the nbThank to set
	 */
	public void setNbThank(int nbThank) {
		this.nbThank = nbThank;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
}