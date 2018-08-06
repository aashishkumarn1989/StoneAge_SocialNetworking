package com.social.beans;

import java.sql.Timestamp;

public class UserPostMessage {

	String name;
	String message;
	Timestamp msgPostedTimestamp;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getMsgPostedTimestamp() {
		return msgPostedTimestamp;
	}
	public void setMsgPostedTimestamp(Timestamp msgPostedTimestamp) {
		this.msgPostedTimestamp = msgPostedTimestamp;
	}
	
	
	
	
	
	
}
