package com.socialmedia.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.socialmedia.user.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	//@Query("SELECT u FROM UserEntity u LEFT JOIN FETCH u.posts")
	//public List<UserEntity> getAllPostsOfUser(); 
	
	@Override
	@EntityGraph(attributePaths = {"posts"})
	List<UserEntity> findAll();
}
