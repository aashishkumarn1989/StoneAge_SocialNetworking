/**
 * 
 */
package com.social.rest.service;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.social.beans.Message;

/**
 * @author Aash
 *
 */
public class SocialNetworkHomeServiceImplTest {

	SocialNetworkHomeServiceImpl target;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		target = new SocialNetworkHomeServiceImpl();
	}

	
	@Test
	public void getFollowingUserMessagesNulltest() {
	List<Message> messageList = new LinkedList<>();	
	assertEquals(messageList, target.getFollowingUserMessages(null));	
	}
	
	@Test
	public void getFollowingUserMessagesUserNotPresentTest() {
	List<Message> messageList = new LinkedList<>();	
	String userId = "aashish";
	assertEquals(messageList, target.getFollowingUserMessages(userId));	
	}
	
	
	@Test
	public void UserNullFollowUserNullTest() {	
	assertEquals(false, target.followUser(null,null));	
	}
	
	@Test
	public void userEmptyFollowUserNullTest() {	
	assertEquals(false, target.followUser("",null));	
	}
	
	
	@Test
	public void userNullFollowUserEmptyTest() {	
	assertEquals(false, target.followUser(null,""));	
	}
	
	@Test
	public void userEmptyFollowUserEmptyTest() {	
	assertEquals(false, target.followUser("",""));	
	}
	
	@Test
	public void followUserTest_success() {	
		String userId = "aashish";
		String followUserId = "akash";	
		assertEquals(true, target.followUser(userId,followUserId));	
	}
	
	@Test
	public void getUserMessagesUserNullTest() {
	List<Message> messageList = new LinkedList<>();	
	String userId = null;
	assertEquals(messageList, target.getUserMessages(userId));	
	}
	
	@Test
	public void getUserMessagesUserEmptyTest() {
	List<Message> messageList = new LinkedList<>();	
	String userId = "";
	assertEquals(messageList, target.getUserMessages(userId));	
	}
	
	
	@Test
	public void postMessageNullUserNullMessageTest() {	
		String userId = null;
		String message = null;	
		assertEquals(false, target.followUser(userId,message));	
	}
	
	@Test
	public void postMessageEmptyUserNullMessageTest() {	
		String userId = "";
		String message = null;	
		assertEquals(false, target.followUser(userId,message));
	}
	
	@Test
	public void postMessageEmptyUserEmptyMessageTest() {	
		String userId = "";
		String message = "";	
		assertEquals(false, target.followUser(userId,message));
	}
	
	@Test
	public void postMessageTest_success() {	
		String userId = "aashish";
		String message = "Hello";	
		assertEquals(true, target.followUser(userId,message));	
	}
	
	
	
	
	
	
	
	
	

}
