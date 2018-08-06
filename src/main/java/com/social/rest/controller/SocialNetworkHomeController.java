package com.social.rest.controller;

import java.sql.Timestamp;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.social.beans.Home;
import com.social.beans.Message;
import com.social.beans.User;
import com.social.beans.UserFollowResponse;
import com.social.beans.UserPostMessage;
import com.social.beans.UserPostMessageResponse;
import com.social.beans.UserRegistration;
import com.social.beans.UserRegistrationResponse;
import com.social.rest.service.ISocialNetworkService;
import com.social.rest.service.SocialNetworkHomeServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/socialNetwork")
@Api(value="Social Network App", description="Application to post messages and following different users.")
public class SocialNetworkHomeController {
	
	private static final String welcomemsg = "Welcome Mr. %s!";
	
	ISocialNetworkService socialNetworkService = new SocialNetworkHomeServiceImpl();
	
	@ApiOperation(value = "Register user", response = UserRegistrationResponse.class)
	@ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully retrieved list"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    })
	@RequestMapping(method = RequestMethod.POST, value="/registerUser")
    @ResponseBody
    public UserRegistrationResponse registerUser(@RequestBody UserRegistration userRegistration) {
    	UserRegistrationResponse userRegResp = new UserRegistrationResponse();
    	String registrationNumber = socialNetworkService.registerUser((userRegistration != null && userRegistration.getName() != null) ? userRegistration.getName() : null);	
    	userRegResp.setName(userRegistration.getName());
    	userRegResp.setAge(userRegistration.getAge());
    	userRegResp.setRegistrationNumber(registrationNumber);
    	userRegResp.setRegistrationStatus("Successful");
    	return userRegResp;
    }
    
	@ApiOperation(value = "Posting a message", response = UserPostMessageResponse.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@RequestMapping(method = RequestMethod.POST, value="/postMessage")
    @ResponseBody
    public UserPostMessageResponse postMessage(@RequestBody UserPostMessage userMessageRequest) {
    	UserPostMessageResponse userPostMsgResp = new UserPostMessageResponse();
    	Boolean isMessagePosted = false;
    	if((userMessageRequest != null && userMessageRequest.getName() != null 
    			&& userMessageRequest.getMessage() != null)) {
    	isMessagePosted = socialNetworkService.postMessage(userMessageRequest.getName()
    			,userMessageRequest.getMessage());				
    	userPostMsgResp.setName(userMessageRequest.getName());
    	userPostMsgResp.setMessage(userMessageRequest.getMessage());
    	}
    	userPostMsgResp.setPostMessageStatus(isMessagePosted ? "Successful" : "Failure");
    	userPostMsgResp.setPostedMessageTimestamp(isMessagePosted ? new Timestamp(System.currentTimeMillis()): null);
    	return userPostMsgResp;
    }
    
	@ApiOperation(value = "Get all messages of the user", response = List.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@GetMapping("/getUserMessages")
    @ResponseBody
    public List<Message> getUserMessages(@RequestParam(name="userId", required=false) String userId) {
    	List<Message> userMessagesResp;
    	userMessagesResp = socialNetworkService.getUserMessages(userId);	
    	
    	return userMessagesResp;
    }
    
	@ApiOperation(value = "Follow a user", response = UserFollowResponse.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@RequestMapping(method = RequestMethod.POST, value="/followUser")
    @ResponseBody
    public UserFollowResponse followUser(@RequestParam(name="userId", required=false) String userId, 
    		@RequestParam(name="followUserId", required=false) String followUserId) {
    	UserFollowResponse userFollowResp = new UserFollowResponse();
    	Boolean isUserFollowing  = socialNetworkService.followUser(userId,followUserId);	
    	userFollowResp.setUserName(userId);
    	userFollowResp.setFollowName(followUserId);
    	userFollowResp.setFollowStatus(isUserFollowing ? "Sucess": "Failure");
    	userFollowResp.setFollowTimestamp(new Timestamp(System.currentTimeMillis()));
    	return userFollowResp;
    }
    
	@ApiOperation(value = "Get all messages of the following", response = UserFollowResponse.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@GetMapping("/getFollowingUserMessages")
    @ResponseBody
    public List<Message> getFollowingUserMessages(@RequestParam(name="userId", required=true) String userId) {
    	List<Message> followingUserMessagesResp;
    	followingUserMessagesResp = socialNetworkService.getFollowingUserMessages(userId);	
    	return followingUserMessagesResp;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
