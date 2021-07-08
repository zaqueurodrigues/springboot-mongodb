package com.zaqueurodrigues.springmongo.repository;

import com.zaqueurodrigues.springmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}


