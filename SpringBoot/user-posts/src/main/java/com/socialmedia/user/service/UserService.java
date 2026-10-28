package com.socialmedia.user.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.socialmedia.posts.entity.PostsEntity;
import com.socialmedia.user.entity.UserEntity;
import com.socialmedia.user.exception.UserDoesNotFoundException;
import com.socialmedia.user.repository.UserRepository;
import com.socialmedia.user.request.UserRequest;
import com.socialmedia.user.response.UserResponse;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public UserResponse createUser(UserRequest userRequest) {
		
		UserEntity userEntity = new UserEntity();
		
		//setting request attributes
		
		userEntity.setName(userRequest.getName());
		userEntity.setUsername(userRequest.getUsername());
		userEntity.setEmail(userRequest.getEmail());
		userEntity.setPassword(userRequest.getPassword());
		userEntity.setPhNo(userRequest.getPhNo());
		userEntity.setBio(userRequest.getBio());
		
		UserEntity response = userRepository.save(userEntity);
		
		
		UserResponse userResponse = new UserResponse();
		
		userResponse.setName(response.getName());
		userResponse.setUsername(response.getUsername());
		userResponse.setStatus("Active");
		
		return userResponse;
		
		
		
	}
	
	public List<UserResponse> getAllUsers(){
		
		List<UserEntity> userEntities = (List<UserEntity>) userRepository.findAll();
		
		List<UserResponse> userResponses = new ArrayList<UserResponse>();
		
		for(UserEntity userEntity:userEntities) {
			
			UserResponse userResponse = new UserResponse();
			
			userResponse.setName(userEntity.getName());
			userResponse.setUsername(userEntity.getUsername());
			userResponse.setStatus(userEntity.getStatus());
			
			userResponses.add(userResponse);
			
		}
		
		return userResponses;
		
	}
	
	
	public UserResponse getUserById(Long id) {
		UserResponse userResponse = new UserResponse();
		try {
			UserEntity userEntity = userRepository.findById(id).get();
		
			
		//Setting the response attributes
			

			userResponse.setName(userEntity.getName());;
			userResponse.setUsername(userEntity.getUsername());
		    userResponse.setStatus(userEntity.getStatus());
			
		}catch (Exception e) {
			//This exception handles when the customer is not found
			throw new UserDoesNotFoundException(" User id " + id + " does not exists");
		}
		return userResponse;
		
		
	}
	
	
	public void getAllPostsOfUser() {
		
		//List<UserEntity> userEntities = (List<UserEntity>) userRepository.findAll();
		
       // List<UserEntity> userEntities = userRepository.getAllPostsOfUser();//Using Left join fetch
		
		
		List<UserEntity> userEntities = userRepository.findAll();//using entity graph
		
		
		
		for(UserEntity userEntity:userEntities) {
			
			System.out.println(userEntity.getName());
			System.out.println(userEntity.getUsername());
			
			
			List<PostsEntity> posts = userEntity.getPosts();
			
			System.out.println("Total Posts are: " +posts.size());
		}
		
		
	}

}
