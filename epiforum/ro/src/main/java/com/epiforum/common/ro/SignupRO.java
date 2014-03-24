package com.epiforum.common.ro;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SignupRO extends LoginRO {

	private String		nickname;
	
	private String		firstname;
	
	private String		lastname;

	/**
	 * @return the nickName
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickName the nickName to set
	 */
	public void setNickname(String nickName) {
		this.nickname = nickName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastname(String lastName) {
		this.lastname = lastName;
	}
}