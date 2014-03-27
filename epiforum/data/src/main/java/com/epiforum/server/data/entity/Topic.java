package com.epiforum.server.data.entity;

// Generated Mar 20, 2014 8:33:43 PM by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.epiforum.server.data.listener.ICreateListener;
import com.epiforum.server.data.listener.IUpdateListener;

/**
 * Topic generated by hbm2java
 */
@Entity
@Cacheable
@Table(name = "topic")
@NamedQueries({
	@NamedQuery(
			name = "Topic.getTopTopics",
			query = "SELECT to FROM Topic to ORDER BY to.nbPosts DESC")
})
public class Topic implements Serializable, ICreateListener, IUpdateListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1893330622797626402L;

	private Integer			id;
	private Date			created;
	private Date			modified;
	private Board			board;
	private String			title;
	private String			description;
	private Boolean			locked;
	private Integer			nbPost;

	private List<Post>		posts = new ArrayList<Post>(0);

	public 					Topic() {
	}

	public 					Topic(Board board, String title, String description, Boolean locked) {
		this.board = board;
		this.title = title;
		this.description = description;
		this.locked = locked;
		this.nbPost = 0;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer 			getId() {
		return this.id;
	}

	public void 			setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "boardId", nullable = false)
	public Board 			getBoard() {
		return this.board;
	}

	public void 			setBoard(Board board) {
		this.board = board;
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

	@Column(name = "title", nullable = false, length = 64)
	public String 			getTitle() {
		return this.title;
	}

	public void 			setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description", length = 256)
	public String 			getDescription() {
		return this.description;
	}

	public void 			setDescription(String description) {
		this.description = description;
	}

	@Column(name = "locked", nullable = false, columnDefinition = "BIT")
	public boolean 			isLocked() {
		return this.locked;
	}

	public void 			setLocked(boolean locked) {
		this.locked = locked;
	}

	@Column(name = "nbPost", nullable = false)
	public Integer			getNbPosts() {
		return this.nbPost;
	}

	public void				setNbPosts(Integer posts) {
		this.nbPost = posts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
	public List<Post> 		getPosts() {
		return this.posts;
	}

	public void 			setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	public Integer			addNbPost() {
		this.nbPost +=1;
		return this.nbPost;
	}
}