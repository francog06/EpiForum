package com.epiforum.common.ro;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProfileInfoRO {
	
	protected String			type;

	protected String			firstname;

	protected String			lastname;

	protected String			nickname;

	protected String			phone;

	protected String			facebookPage;

	protected String			twitterPage;

	protected String			skypeContact;

	protected String			city;

	protected String			description;

	protected Boolean			gender;

	protected Date				birthdate;

	protected Integer			nbPost;

	protected Integer			nbThank;

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the facebookPage
	 */
	public String getFacebookPage() {
		return facebookPage;
	}
	/**
	 * @param facebookPage the facebookPage to set
	 */
	public void setFacebookPage(String facebookPage) {
		this.facebookPage = facebookPage;
	}
	/**
	 * @return the twitterPage
	 */
	public String getTwitterPage() {
		return twitterPage;
	}
	/**
	 * @param twitterPage the twitterPage to set
	 */
	public void setTwitterPage(String twitterPage) {
		this.twitterPage = twitterPage;
	}
	/**
	 * @return the skypeContact
	 */
	public String getSkypeContact() {
		return skypeContact;
	}
	/**
	 * @param skypeContact the skypeContact to set
	 */
	public void setSkypeContact(String skypeContact) {
		this.skypeContact = skypeContact;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the gender
	 */
	public Boolean getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(Boolean gender) {
		this.gender = gender;
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
}