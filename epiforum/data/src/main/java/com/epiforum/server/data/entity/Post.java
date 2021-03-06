package com.epiforum.server.data.entity;

// Generated Mar 20, 2014 8:33:43 PM by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.epiforum.server.data.listener.ICreateListener;
import com.epiforum.server.data.listener.IUpdateListener;

/**
 * Post generated by hbm2java
 */
@Entity
@Cacheable
@Table(name = "post")
@NamedQueries({
	@NamedQuery(
			name = "Post.countAll",
			query = "SELECT count(po) FROM Post po WHERE po.deleted = false"),
	@NamedQuery(
			name = "Post.getAllPostNotDeleted",
			query = "SELECT po FROM Post po WHERE po.topic.id = :topicId AND po.deleted = false ORDER BY po.created"),
	@NamedQuery(
			name = "Post.getTopicsFromTag",
			query = "SELECT DISTINCT po.topic FROM Post po WHERE po.tag LIKE :search")
})
public class Post implements Serializable, ICreateListener, IUpdateListener {

	private static final long serialVersionUID = -1522885153822140621L;

	private Integer			id;
	private Date			created;
	private Date			modified;
	private Topic			topic;
	private Profile			profile;
	private String			tag;
	private Boolean			deleted;
	private ContentPost		contentPost;

	public 					Post() {
	}

	public 					Post(Topic topic, Profile profile) {
		this.topic = topic;
		this.profile = profile;
		this.deleted = false;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer 			getId() {
		return this.id;
	}

	public void				setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "topicId", nullable = false)
	public Topic 			getTopic() {
		return this.topic;
	}

	public void 			setTopic(Topic topic) {
		this.topic = topic;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profileId", nullable = false)
	public Profile 			getProfile() {
		return this.profile;
	}

	public void 			setProfile(Profile profile) {
		this.profile = profile;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false, length = 19)
	public Date 			getCreated() {
		return this.created;
	}

	public void 			setCreated(Date created) {
		this.created = created;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified", nullable = false, length = 19)
	public Date 			getModified() {
		return this.modified;
	}

	public void 			setModified(Date modified) {
		this.modified = modified;
	}

	@Column(name = "tag", length = 64)
	public String 			getTag() {
		return this.tag;
	}

	public void 			setTag(String tag) {
		this.tag = tag;
	}

	@Column(name = "deleted", nullable = false, columnDefinition = "BIT")
	public boolean 			isDeleted() {
		return this.deleted;
	}

	public void 			setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "post")
	public ContentPost 		getContentPost() {
		return this.contentPost;
	}

	public void 			setContentPost(ContentPost contentPost) {
		this.contentPost = contentPost;
	}
}