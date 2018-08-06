package com.social.beans;

import java.sql.Timestamp;

public class Message {
	
	String messageId;
	String messageDesc;
	String userId;
	Timestamp messageTimeStamp;
	String userRegistrationNumber;
	
	
	
	public String getUserRegistrationNumber() {
		return userRegistrationNumber;
	}
	public void setUserRegistrationNumber(String userRegistrationNumber) {
		this.userRegistrationNumber = userRegistrationNumber;
	}
	public Timestamp getMessageTimeStamp() {
		return messageTimeStamp;
	}
	public void setMessageTimeStamp(Timestamp messageTimeStamp) {
		this.messageTimeStamp = messageTimeStamp;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getMessageDesc() {
		return messageDesc;
	}
	public void setMessageDesc(String messageDesc) {
		this.messageDesc = messageDesc;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

}
