package com.socialmedia.posts.service;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.socialmedia.posts.entity.PostsEntity;
import com.socialmedia.posts.repository.PostsRepository;
import com.socialmedia.posts.request.PostsRequest;
import com.socialmedia.posts.response.PostsResponse;
import com.socialmedia.user.entity.UserEntity;
import com.socialmedia.user.repository.UserRepository;
import com.socialmedia.user.request.UserRequest;

@Service
public class PostsService {
	
	@Autowired
	PostsRepository postsRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public PostsResponse createPosts(PostsRequest postsRequest) {
		
        Long userId = postsRequest.getUserId();
		
		UserEntity userEntity= userRepository.findById(Long.valueOf(userId)).get();
		
		PostsEntity postsEntity = new PostsEntity();
	
		postsEntity.setUser(userEntity);
		postsEntity.setContent(generateContent());
		postsEntity.setPostDate(new Date());
		postsEntity.setStatus("Uploaded");
		postsEntity.setLikes(generateLikes());
		PostsEntity response = postsRepository.save(postsEntity);
		
		PostsResponse postsResponse = new PostsResponse();
		
		postsResponse.setStatus("Post uploaded");
		postsResponse.setComments(generateComments());
		postsResponse.setLikes(generateLikes());
		
		return postsResponse;
		
		
		
	}
	
	private int generateLikes() {
		Random random = new Random();
		int likes = 1000 + random.nextInt(9000);
		return likes;
	}
	
	private String generateComments() {
	    String[] comments = {
	        "Amazing post! 🔥",
	        "Love this! ❤️",
	        "This looks awesome 😍",
	        "Great content! 👏",
	        "Absolutely beautiful! ✨",
	        "Nice one! 👍",
	        "Keep sharing! 💯",
	        "This made my day 😊",
	        "Wow, incredible! 🤩",
	        "So inspiring! 🌟"
	    };

	    Random random = new Random();
	    return comments[random.nextInt(comments.length)];
	}
	
	private String generateContent() {
	    String[] contents = {
	        "Enjoying the little moments in life 🌸",
	        "Beautiful day, beautiful memories ✨",
	        "Exploring new places and making memories 🌍",
	        "Good vibes, great people, and unforgettable moments ❤️",
	        "Life is better when you smile 😊",
	        "Chasing dreams and creating memories 🚀",
	        "Weekend mood: Relax, travel, repeat ✈️",
	        "Making every moment count 📸",
	        "Happiness is found in simple things 🌿",
	        "New day, new adventures! 🌟"
	    };

	    Random random = new Random();
	    return contents[random.nextInt(contents.length)];
	}


}
