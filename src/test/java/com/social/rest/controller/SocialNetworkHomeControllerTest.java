package com.social.rest.controller;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.social.beans.Message;
import com.social.beans.UserFollowResponse;
import com.social.beans.UserPostMessageResponse;

public class SocialNetworkHomeControllerTest {

	SocialNetworkHomeController target;

	@Before
	public void setUp() throws Exception {
		target = new SocialNetworkHomeController();
	}

	@Test
	public void getFollowingUserMessagesNullUserTest() {
		List<Message> followingUsersMessageList = new LinkedList<>();
		assertEquals(followingUsersMessageList, target.getFollowingUserMessages(null));	
	}
	
	@Test
	public void followUserNullUserFollowTest() {
		UserFollowResponse userFollowResp = new UserFollowResponse();
    	userFollowResp.setFollowStatus("Failure");
		assertEquals(userFollowResp.getFollowStatus(), target.followUser(null,null).getFollowStatus());
		
	}
	
	@Test
	public void getUserMessagesNullUserTest() {
		List<Message> userMessageList = new LinkedList<>();
		assertEquals(userMessageList, target.getUserMessages(null));	
	}
	
	@Test
	public void postMessgeNullTest() {
		UserPostMessageResponse userPostMsgResp = new UserPostMessageResponse();
		userPostMsgResp.setPostMessageStatus("Failure");
		assertEquals(userPostMsgResp.getPostMessageStatus(), target.postMessage(null).getPostMessageStatus());
		
	}
	
	
	
	
	

}
