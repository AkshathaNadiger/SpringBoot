package com.socialmedia.posts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.posts.request.PostsRequest;
import com.socialmedia.posts.response.PostsResponse;
import com.socialmedia.posts.service.PostsService;

@RestController
@RequestMapping("/posts")
public class PostsController {
	
	@Autowired
	PostsService postsService;
	
	@PostMapping("create")
	public ResponseEntity<PostsResponse> createPosts(@RequestBody PostsRequest postsRequest){
		
		PostsResponse postsResponse = postsService.createPosts(postsRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(postsResponse);
		
	}

}
