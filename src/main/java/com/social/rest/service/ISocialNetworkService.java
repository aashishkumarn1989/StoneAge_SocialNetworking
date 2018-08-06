package com.social.rest.service;

import java.util.List;

import com.social.beans.Message;

public interface ISocialNetworkService {

	public String registerUser(String name);	
	public Boolean postMessage(String userId,String message);
	public List<Message> getUserMessages(String userId);
	public Boolean followUser(String userId, String followUserId);
	public List<Message> getFollowingUserMessages(String userId);
	
}
