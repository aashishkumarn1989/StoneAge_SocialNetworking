package com.social.rest.service;

import static org.assertj.core.api.Assertions.useDefaultDateFormatsOnly;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.social.beans.Message;
import com.social.beans.User;
import com.social.beans.UserRegistration;
import com.social.beans.util.MsgTimestampComparator;


public class SocialNetworkHomeServiceImpl implements ISocialNetworkService {

	static Map<String,List<Message>> userMessageMap = new HashMap<>();
	static Map<String,User> userRegistrationMap = new HashMap<>();
	static Map<String,Set<String>> followingUserMap = new HashMap<>();
	
	
	/**
	 * Post Message : API to post the messaged of the sender
	 *
	 */
	@Override
	public Boolean postMessage(String userName, String message) {

		Boolean isMessagePosted = false;
		//register the user
		if((userName != null && !userName.isEmpty())
				&& (message != null && !message.isEmpty())) {
			String registerationNumber = registerUser(userName);
			String messageId = UUID.randomUUID().toString();
			List<Message> msgList;
			Message newMsg = new Message();
			newMsg.setMessageId(messageId);
			newMsg.setMessageDesc(message);
			newMsg.setMessageTimeStamp(new Timestamp(System.currentTimeMillis()));
			newMsg.setUserId(userName);
			newMsg.setUserRegistrationNumber(registerationNumber);
			
			if(userMessageMap.get(userName) != null){
				msgList = userMessageMap.get(userName);
			}else {
				msgList = new LinkedList<>();
			}
			msgList.add(newMsg);
			userMessageMap.put(userName,msgList);
			isMessagePosted = true;
		}
		return isMessagePosted;
	}


	
	/**
	 * Register User : API to register the user
	 *
	 */
	@Override
	public String registerUser(String name) {
		
		String userRegisterationNumber = null;
		if(name != null 
				|| !userRegistrationMap.containsKey(name)){
			User newUser = new User();
			newUser.setUserId(UUID.randomUUID().toString());
			newUser.setUserName(name);
			newUser.setUserRegistrationDateTimeStamp(new Timestamp(System.currentTimeMillis()));
			userRegistrationMap.put(name,newUser);
			userRegisterationNumber = newUser.getUserId();
		}else {
			userRegisterationNumber = userRegistrationMap.get(name).getUserId();
		}	
		
		return userRegisterationNumber;
	}



	@Override
	public List<Message> getUserMessages(String userId) {	
		List<Message> userMessages = new LinkedList<>();
		if(userId != null && !userId.isEmpty()) {
			if(userRegistrationMap.get(userId) != null) {
				userMessages = userMessageMap.get(userId);
			}
			Collections.sort(userMessages,new MsgTimestampComparator());
		}
		return userMessages;
	}



	@Override
	public Boolean followUser(String userId, String followUserId) {

		Boolean followUser = false;
		if((userId != null && !userId.isEmpty())
				&& (followUserId != null && !followUserId.isEmpty())) {
			Set<String> followingSet = null;
			if(followingUserMap.get(userId) != null) {
				followingSet = followingUserMap.get(userId);		
			}else{
				followingSet = new LinkedHashSet<String>();
			} 
			followingSet.add(followUserId);
			followingUserMap.put(userId,followingSet);
			followUser = true;
		}
		return followUser;
	}

	
	public List<Message> getFollowingUserMessages(String userId){
		
		List<Message> followingUserMessages = new LinkedList<>();
		Set<String> followingUsers = null ;
		
		if(userRegistrationMap.containsKey(userId)) {
			if(followingUserMap.get(userId) != null) {
				followingUsers = followingUserMap.get(userId);
			}
			for (String user : followingUsers) {
				List<Message> userList = new LinkedList<>();
				userList = getUserMessages(user);
				followingUserMessages.addAll(userList);
			}	
		}
		Collections.sort(followingUserMessages,new MsgTimestampComparator());
		return followingUserMessages;
		
	}
	
	
	
}
