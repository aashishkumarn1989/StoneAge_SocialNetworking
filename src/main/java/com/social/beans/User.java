package com.social.beans;

import java.sql.Timestamp;

public class User {

	String userId;
	String userName;
	Timestamp userRegistrationDateTimeStamp;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Timestamp getUserRegistrationDateTimeStamp() {
		return userRegistrationDateTimeStamp;
	}
	public void setUserRegistrationDateTimeStamp(Timestamp userRegistrationDateTimeStamp) {
		this.userRegistrationDateTimeStamp = userRegistrationDateTimeStamp;
	}
	
	
	
}
