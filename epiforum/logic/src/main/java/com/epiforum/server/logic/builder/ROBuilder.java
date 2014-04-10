package com.epiforum.server.logic.builder;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.epiforum.common.ro.BoardRO;
import com.epiforum.common.ro.CategoryRO;
import com.epiforum.common.ro.ContentRO;
import com.epiforum.common.ro.LightProfileRO;
import com.epiforum.common.ro.MemberRO;
import com.epiforum.common.ro.MyLightProfileRO;
import com.epiforum.common.ro.MyProfileRO;
import com.epiforum.common.ro.PostRO;
import com.epiforum.common.ro.TopTopicRO;
import com.epiforum.common.ro.TopicRO;
import com.epiforum.server.data.entity.Board;
import com.epiforum.server.data.entity.Category;
import com.epiforum.server.data.entity.Post;
import com.epiforum.server.data.entity.Profile;
import com.epiforum.server.data.entity.Session;
import com.epiforum.server.data.entity.Topic;

public class ROBuilder {

	private ROBuilder() {}

	public static LightProfileRO		createLightProfileRO(Profile profile) {
		LightProfileRO pro = new LightProfileRO();
		pro.setNickname(profile.getNickname());
		pro.setPicture(profile.isPicture());
		pro.setNbThank(profile.getNbThanks());
		pro.setNbPost(profile.getNbPosts());
		return pro;
	}

	public static MyLightProfileRO		createMyLightProfileRO(Profile profile) throws ParseException {
		MyLightProfileRO pro = new MyLightProfileRO();
		pro.setCreated(profile.getCreated());
		pro.setType(profile.getAccount().getType().toString());
		pro.setNickname(profile.getNickname());
		pro.setFirstname(profile.getFirstname());
		pro.setPicture(profile.isPicture());
		pro.setLastname(profile.getLastname());
		if (profile.getBirthdate() != null) {
			pro.setBirthdate(profile.getBirthdate());
		}
		pro.setNbPost(profile.getNbPosts());
		pro.setNbThank(profile.getNbThanks());
		return pro;
	}

	public static MyProfileRO			createMyProfileRO(Profile pro, Session se) throws ParseException {
		MyProfileRO myPro = new MyProfileRO();
		myPro.setType(pro.getAccount().getType().toString());
		myPro.setCreated(pro.getCreated());
		myPro.setFirstname(pro.getFirstname());
		myPro.setLastname(pro.getLastname());
		myPro.setNickname(pro.getNickname());
		myPro.setPhone(pro.getPhone());
		myPro.setFacebookPage(pro.getFacebookPage());
		myPro.setTwitterPage(pro.getTwitterPage());
		myPro.setCity(pro.getCity());
		myPro.setSkypeContact(pro.getSkypeContact());
		myPro.setDescription(pro.getDescription());
		myPro.setGender(pro.isGender());
		myPro.setPicture(pro.isPicture());
		myPro.setBirthdate(pro.getBirthdate());
		myPro.setNbPost(pro.getNbPosts());
		myPro.setNbThank(pro.getNbThanks());
		myPro.setSignature(pro.getSignature());
		if (se != null) {
			myPro.setEmail(pro.getAccount().getEmail());
		}
		return myPro;
	}

	public static CategoryRO			createCategoryRO(Category cat) {
		CategoryRO catRo = new CategoryRO();
		catRo.setId(cat.getId());
		catRo.setModified(cat.getModified());
		catRo.setTitle(cat.getTitle());
		catRo.setDescription(cat.getDescription());
		return catRo;
	}

	public static BoardRO				createBoardRO(Board board) throws ParseException {
		BoardRO boardRo = new BoardRO();
		boardRo.setId(board.getId());
		boardRo.setModified(board.getModified());
		boardRo.setTitle(board.getTitle());
		boardRo.setDescription(board.getDescription());
		return boardRo;
	}

	public static TopicRO				createTopicRO(Topic topic) {
		TopicRO to = new TopicRO();
		to.setId(topic.getId());
		to.setModified(topic.getModified());
		to.setTitle(topic.getTitle());
		to.setNbPost(topic.getNbPosts());
		to.setDescription(topic.getDescription());
		to.setLocked(topic.getLocked());
		return to;
	}

	private static List<String>			createTagList(String tagl) {
		if (tagl != null && !tagl.trim().isEmpty()) {
			List<String> tags = new ArrayList<String>();
			for (String tag : tagl.split("#")) {
				if (!tag.trim().isEmpty()) {
					tags.add("#" + tag);
				}
			}
			return tags;
		}
		return null;
	}

	public static PostRO				createPostRO(Post post) {
		PostRO po = new PostRO();
		po.setId(post.getId());
		po.setModified(post.getCreated());
		po.setProfileId(post.getProfile().getId());
		po.setContent(post.getContentPost().getContent());
		po.setProfileSignature(post.getProfile().getSignature());
		po.setProfile(createLightProfileRO(post.getProfile()));
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

	public static TopTopicRO			createTopTopicRO(Topic topic) {
		TopTopicRO top = new TopTopicRO();
		top.setTitle(topic.getTitle());
		top.setNbPost(topic.getNbPosts());
		top.setId(topic.getId());
		return top;
	}

	public static ContentRO				createContentRO(Topic top) {
		ContentRO lightTopic = new ContentRO();
		lightTopic.setPostId(top.getId());
		lightTopic.setContent(top.getTitle());
		return lightTopic;
	}

	public static ContentRO				createContentRO(Board bor) {
		ContentRO lightTopic = new ContentRO();
		lightTopic.setPostId(bor.getId());
		lightTopic.setContent(bor.getTitle());
		return lightTopic;
	}

	public static ContentRO				createContentRO(Category cat) {
		ContentRO lightTopic = new ContentRO();
		lightTopic.setPostId(cat.getId());
		lightTopic.setContent(cat.getTitle());
		return lightTopic;
	}
}