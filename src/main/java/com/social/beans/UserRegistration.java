package com.social.beans;

import java.sql.Timestamp;
import java.util.Date;

public class UserRegistration {

	String name;
	Integer age;
	String userId;
	Timestamp registeredTimestamp;
	

	public Timestamp getRegisteredTimestamp() {
		return registeredTimestamp;
	}
	public void setRegisteredTimestamp(Timestamp registeredTimestamp) {
		this.registeredTimestamp = registeredTimestamp;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

}
