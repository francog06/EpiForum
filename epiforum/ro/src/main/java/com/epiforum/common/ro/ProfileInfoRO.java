package com.epiforum.common.ro;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProfileInfoRO extends MyLightProfileRO {
	
	protected String			type;

	protected String			phone;

	protected String			facebookPage;

	protected String			twitterPage;

	protected String			skypeContact;

	protected String			city;

	protected String			description;

	protected Boolean			gender;

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
}