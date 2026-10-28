package com.socialmedia.posts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.socialmedia.posts.entity.PostsEntity;

@Repository
public interface PostsRepository extends CrudRepository<PostsEntity, Long>{

}
