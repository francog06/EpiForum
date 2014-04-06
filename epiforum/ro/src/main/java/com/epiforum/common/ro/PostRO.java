package com.epiforum.common.ro;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PostRO extends ContentRO {

	private Integer			topicId;

	private Integer			profileId;

	private String			profileSignature;

	private LightProfileRO 	profile;

	private List<String>	tags;

	/**
	 * @return the topicId
	 */
	public Integer getTopicId() {
		return topicId;
	}

	/**
	 * @param topicId the topicId to set
	 */
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	/**
	 * @return the profileId
	 */
	public int getProfileId() {
		return profileId;
	}

	/**
	 * @param profileId the profileId to set
	 */
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	/**
	 * @return the profileSignature
	 */
	public String getProfileSignature() {
		return profileSignature;
	}

	/**
	 * @param profileSignature the profileSignature to set
	 */
	public void setProfileSignature(String profileSignature) {
		this.profileSignature = profileSignature;
	}

	/**
	 * @return the tag
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	/**
	 * @return the profile
	 */
	public LightProfileRO getProfile() {
		return profile;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setProfile(LightProfileRO profile) {
		this.profile = profile;
	}
}
