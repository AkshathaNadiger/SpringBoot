package com.socialmedia.user.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.user.request.UserRequest;
import com.socialmedia.user.response.UserResponse;
import com.socialmedia.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("create")
	public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){
		
		UserResponse userResponse = userService.createUser(userRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
		
		
	}
	
	@GetMapping("getAllUsers")
	public List<UserResponse> getAllUsers() {

	    return userService.getAllUsers();
	}

	
	@GetMapping("/getAllUsersById/{id}")
	public UserResponse getAllUsersById(@PathVariable Long id) {

	    return userService.getUserById(id);
	}
	
	
	@GetMapping("getAllPostsOfUsers")
	public String getAllPostsOfUsers() {
		userService.getAllPostsOfUser();
		return "SUCCESS";
	}

}
