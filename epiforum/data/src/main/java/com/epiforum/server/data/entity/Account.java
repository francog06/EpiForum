package com.epiforum.server.data.entity;

// Generated Mar 20, 2014 8:33:43 PM by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.epiforum.server.data.listener.ICreateListener;
import com.epiforum.server.data.listener.IUpdateListener;

/**
 * Account generated by hbm2java
 */
@Entity
@Table(name = "account", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@NamedQueries({
	@NamedQuery(
			name = "Account.getAll",
			query = "SELECT ac FROM Account ac WHERE ac.status = :status"),
	@NamedQuery(
			name = "Account.countAccounts",
			query = "SELECT count(ac) FROM Account ac WHERE ac.status = :status"),
	@NamedQuery(
			name = "Account.getAccountFromEmail", 
			query = "SELECT ac FROM Account ac WHERE ac.email = :email"),
	@NamedQuery(
			name = "Account.getAccountFromEmailAndPassword", 
			query = "SELECT ac FROM Account ac WHERE ac.email = :email AND ac.password = :password AND" +
					" ac.status = :status AND ac.type >= :type"),
	@NamedQuery(
			name = "Account.emailIsUsed",
			query = "SELECT 1 FROM Account ac WHERE ac.email = :email")
})
public class Account implements Serializable, ICreateListener, IUpdateListener {

	private static final long serialVersionUID = 8865866543120431776L;

	public enum Status {
		DISABLED,
		PENDING,
		ACTIVATED
	}

	public enum Type {
		MEMBRE,
		MODERATEUR,
		ADMIN
	}

	private Integer			id;
	private Date			created;
	private Date			modified;
	private Status			status;
	private Type			type;
	private String			email;
	private String			password;
	private String			activationCode;
	private String			ipAddress;
	private Profile			profile;

	public 					Account() {
	}

	public 					Account(Status status, Type type, String email, String password, String activationCode, String ipAddress) {
		this.status = status;
		this.type = type;
		this.email = email;
		this.password = password;
		this.activationCode = activationCode;
		this.ipAddress = ipAddress;
	}

	public 					Account(Status status, Type type, String email, String password, String activationCode, String ipAddress, Profile profile) {
		this.status = status;
		this.type = type;
		this.email = email;
		this.password = password;
		this.activationCode = activationCode;
		this.ipAddress = ipAddress;
		this.profile = profile;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer			getId() {
		return this.id;
	}

	public void				setId(Integer id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false, length = 19)
	public Date				getCreated() {
		return this.created;
	}

	public void				setCreated(Date created) {
		this.created = created;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified", nullable = false, length = 19)
	public Date				getModified() {
		return this.modified;
	}

	public void				setModified(Date modified) {
		this.modified = modified;
	}

	@Column(name = "status", nullable = false)
	public Status			getStatus() {
		return this.status;
	}

	public void				setStatus(Status status) {
		this.status = status;
	}

	@Column(name = "type", nullable = false)
	public Type				getType() {
		return this.type;
	}

	public void				setType(Type type) {
		this.type = type;
	}

	@Column(name = "email", unique = true, nullable = false, length = 128)
	public String			getEmail() {
		return this.email;
	}

	public void				setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 64)
	public String			getPassword() {
		return this.password;
	}

	public void				setPassword(String password) {
		this.password = password;
	}

	@Column(name = "activationCode", nullable = false, length = 16)
	public String			getActivationCode() {
		return this.activationCode;
	}

	public void				setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	@Column(name = "ipAddress", nullable = false, length = 16)
	public String			getIpAddress() {
		return this.ipAddress;
	}

	public void				setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "account")
	public Profile			getProfile() {
		return this.profile;
	}

	public void				setProfile(Profile profile) {
		this.profile = profile;
	}
}