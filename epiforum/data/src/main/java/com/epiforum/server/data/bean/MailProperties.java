package com.epiforum.server.data.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MailProperties implements Serializable {


	/**
	 * NEEDED FOR SERIALIZATION
	 */
	private static final long serialVersionUID = 2177090071035252852L;

	private String 						from;
	private List<String>				to;
	private List<String>				cc;
	private List<String>				bcc;
	private String						subject;
	private String						content;
	private List<MailAttachment>		attachments;
		
	public MailProperties () {
		this.to = new ArrayList<String>();
		this.cc = new ArrayList<String>();
		this.bcc = new ArrayList<String>();
		this.attachments = new ArrayList<MailAttachment>();
	}
	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public List<String> getTo() {
		return to;
	}

	public void setTo(List<String> to) {
		this.to = to;
	}

	public List<String> getCc() {
		return cc;
	}

	public void setCc(List<String> cc) {
		this.cc = cc;
	}

	public List<String> getBcc() {
		return bcc;
	}

	public void setBcc(List<String> cci) {
		this.bcc = cci;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<MailAttachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<MailAttachment> attachments) {
		this.attachments = attachments;
	}

}
