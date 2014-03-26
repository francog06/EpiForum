package com.epiforum.server.logic.builder;

import java.util.ArrayList;
import java.util.List;

import com.epiforum.common.ro.MyLightProfileRO;
import com.epiforum.common.ro.MyProfileRO;
import com.epiforum.common.ro.PostRO;
import com.epiforum.common.ro.RandomPasswordRO;
import com.epiforum.common.ro.TopicRO;
import com.epiforum.server.data.entity.Post;
import com.epiforum.server.data.entity.Profile;
import com.epiforum.server.data.entity.Session;
import com.epiforum.server.data.entity.Topic;

public class ROBuilder {

	private ROBuilder() {}

	public static RandomPasswordRO		createRO(String pass) {
		RandomPasswordRO passwordRo = new RandomPasswordRO();
		passwordRo.setPassword(pass);
		return passwordRo;
	}

	public static MyProfileRO			createRO(Profile pro, Session se) {
		MyProfileRO myPro = new MyProfileRO();
		if (se == null) {
			myPro.setType(pro.getAccount().getType().toString());
			myPro.setFirstname(pro.getFirstname());
			myPro.setLastname(pro.getLastname());
			myPro.setNickname(pro.getNickname());
			myPro.setPhone(pro.getPhone());
			myPro.setFacebookPage(pro.getFacebookPage());
			myPro.setTwitterPage(pro.getTwitterPage());
			myPro.setCity(pro.getCity());
			myPro.setSkypeContact(pro.getSkypeContact());
			myPro.setDescription(pro.getDescription());
			myPro.setGender(pro.getGender());
			myPro.setBirthdate(pro.getBirthdate());
			myPro.setNbPost(pro.getNbPosts());
			myPro.setNbThank(pro.getNbThanks());
		} else {
			myPro.setSignature(pro.getSignature());
			myPro.setEmail(pro.getAccount().getEmail());
			myPro.setIpAddress(pro.getAccount().getIpAddress());
		}
		return myPro;
	}
	
	public static TopicRO				createRO(Topic topic) {
		TopicRO to = new TopicRO();
		to.setTitle(topic.getTitle());
		to.setDescription(topic.getDescription());
		to.setLocked(topic.isLocked());
		return to;
	}

	private static List<String>				createTagList(String tagl) {
		if (tagl != null && !tagl.trim().isEmpty()) {
			List<String> tags = new ArrayList<String>();
			for (String tag : tagl.split("#")) {
				tags.add("#" + tag);
			}
			return tags;
		}
		return null;
	}
	public static PostRO				createRO(Post post, Integer profileId, String content) {
		PostRO po = new PostRO();
		po.setProfileId(profileId);
		po.setContent(content);
		po.setTags(createTagList(post.getTag()));
		return po;
	}

	public static PostRO				createRO(Post post) {
		PostRO po = new PostRO();
		po.setProfileId(post.getProfile().getId());
		po.setContent(post.getContentPost().getContent());
		po.setTags(createTagList(post.getTag()));
		return po;
	}

	public static MyLightProfileRO		createRO(Profile profile) {
		MyLightProfileRO pro = new MyLightProfileRO();
		pro.setNickname(profile.getNickname());
		pro.setFirstname(profile.getFirstname());
		pro.setLastname(profile.getLastname());
		pro.setBirthdate(profile.getBirthdate());
		pro.setNbPost(profile.getNbPosts());
		pro.setNbThank(profile.getNbThanks());
		return pro;
	}
}