package com.epiforum.common.ro;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyLightProfileRO {

	protected String			nickname;

	protected String			firstname;

	protected String			lastname;

	protected Date				birthdate;

	protected Integer			nbPost;

	protected Integer			nbThank;

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
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
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
}
