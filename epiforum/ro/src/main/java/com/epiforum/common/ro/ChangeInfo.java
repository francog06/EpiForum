package com.epiforum.common.ro;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ChangeInfo {

	private String		email;

	private String		oldInfo;
	
	private String		newInfo;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the oldInfo
	 */
	public String getOldInfo() {
		return oldInfo;
	}

	/**
	 * @param oldInfo the oldInfo to set
	 */
	public void setOldInfo(String oldInfo) {
		this.oldInfo = oldInfo;
	}

	/**
	 * @return the newInfo
	 */
	public String getNewInfo() {
		return newInfo;
	}

	/**
	 * @param newInfo the newInfo to set
	 */
	public void setNewInfo(String newInfo) {
		this.newInfo = newInfo;
	}
}
