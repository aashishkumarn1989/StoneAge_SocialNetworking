package com.social.beans;

import java.sql.Timestamp;

public class UserPostMessageResponse {


	String name;
	String message;
	String postMessageStatus;
	Timestamp postedMessageTimestamp;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPostMessageStatus() {
		return postMessageStatus;
	}
	public void setPostMessageStatus(String postMessageStatus) {
		this.postMessageStatus = postMessageStatus;
	}
	public Timestamp getPostedMessageTimestamp() {
		return postedMessageTimestamp;
	}
	public void setPostedMessageTimestamp(Timestamp postedMessageTimestamp) {
		this.postedMessageTimestamp = postedMessageTimestamp;
	}
	

	
	
}
