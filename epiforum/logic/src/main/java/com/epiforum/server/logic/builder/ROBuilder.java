package com.epiforum.server.logic.builder;

import java.util.ArrayList;
import java.util.List;

import com.epiforum.common.ro.BoardRO;
import com.epiforum.common.ro.CategoryRO;
import com.epiforum.common.ro.LightProfileRO;
import com.epiforum.common.ro.MemberRO;
import com.epiforum.common.ro.MyLightProfileRO;
import com.epiforum.common.ro.MyProfileRO;
import com.epiforum.common.ro.PostRO;
import com.epiforum.common.ro.TopicRO;
import com.epiforum.server.data.entity.Board;
import com.epiforum.server.data.entity.Category;
import com.epiforum.server.data.entity.Post;
import com.epiforum.server.data.entity.Profile;
import com.epiforum.server.data.entity.Session;
import com.epiforum.server.data.entity.Topic;

public class ROBuilder {

	private ROBuilder() {}

	public static MyProfileRO			createMyProfileRO(Profile pro, Session se) {
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

	public static MyLightProfileRO		createMyLightProfileRO(Profile profile) {
		MyLightProfileRO pro = new MyLightProfileRO();
		pro.setNickname(profile.getNickname());
		pro.setFirstname(profile.getFirstname());
		pro.setLastname(profile.getLastname());
		pro.setBirthdate(profile.getBirthdate());
		pro.setNbPost(profile.getNbPosts());
		pro.setNbThank(profile.getNbThanks());
		return pro;
	}

	public static CategoryRO			createCategoryRO(Category cat) {
		CategoryRO catRo = new CategoryRO();
		catRo.setId(cat.getId());
		catRo.setTitle(cat.getTitle());
		catRo.setDescription(cat.getDescription());
		return catRo;
	}

	public static BoardRO				createBoardRO(Board board) {
		BoardRO boardRo = new BoardRO();
		boardRo.setId(board.getId());
		boardRo.setTitle(board.getTitle());
		boardRo.setDescription(board.getDescription());
		return boardRo;
	}

	public static TopicRO				createTopicRO(Topic topic) {
		TopicRO to = new TopicRO();
		to.setId(topic.getId());
		to.setTitle(topic.getTitle());
		to.setDescription(topic.getDescription());
		to.setLocked(topic.isLocked());
		return to;
	}

	private static List<String>			createTagList(String tagl) {
		if (tagl != null && !tagl.trim().isEmpty()) {
			List<String> tags = new ArrayList<String>();
			for (String tag : tagl.split("#")) {
				tags.add("#" + tag);
			}
			return tags;
		}
		return null;
	}

	public static PostRO				createPostRO(Post post, Integer profileId, String content) {
		PostRO po = new PostRO();
		po.setProfileId(profileId);
		po.setContent(content);
		po.setTags(createTagList(post.getTag()));
		return po;
	}

	public static PostRO				createPostRO(Post post) {
		PostRO po = new PostRO();
		po.setProfileId(post.getProfile().getId());
		po.setContent(post.getContentPost().getContent());
		po.setProfileSignature(post.getProfile().getSignature());
		po.setTags(createTagList(post.getTag()));
		return po;
	}

	public static MemberRO				createMemberRO(Profile pro) {
		MemberRO member = new MemberRO();
		member.setNickname(pro.getNickname());
		member.setNbThank(pro.getNbThanks());
		member.setType(pro.getAccount().getType().ordinal());
		return member;
	}

	public static LightProfileRO		createLightProfileRO(Profile profile) {
		LightProfileRO pro = new LightProfileRO();
		pro.setNickname(profile.getNickname());
		pro.setNbThank(profile.getNbThanks());
		pro.setNbPost(profile.getNbPosts());
		return pro;
	}
}