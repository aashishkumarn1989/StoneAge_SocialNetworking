package com.social.beans;

import java.sql.Timestamp;

public class UserFollowResponse {

	String userName;
	String followName;
	String followStatus;
	Timestamp followTimestamp;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFollowName() {
		return followName;
	}
	public void setFollowName(String followName) {
		this.followName = followName;
	}
	public String getFollowStatus() {
		return followStatus;
	}
	public void setFollowStatus(String followStatus) {
		this.followStatus = followStatus;
	}
	public Timestamp getFollowTimestamp() {
		return followTimestamp;
	}
	public void setFollowTimestamp(Timestamp followTimestamp) {
		this.followTimestamp = followTimestamp;
	}

	
	
	
	
}
