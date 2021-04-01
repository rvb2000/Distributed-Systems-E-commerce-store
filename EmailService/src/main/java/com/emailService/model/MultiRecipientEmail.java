package com.emailService.model;

public class MultiRecipientEmail {
	private String sender;
	private String[] recipients;
	private String subject;
	private String text;
	
	public MultiRecipientEmail() {
		this.sender="no-reply@MajorProject.com";
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	
	public String[] getRecipients() {
		return recipients;
	}
	public void setRecipient(String[] recipients) {
		this.recipients = recipients;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	
}
