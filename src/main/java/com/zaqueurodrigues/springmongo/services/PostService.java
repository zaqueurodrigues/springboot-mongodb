package com.zaqueurodrigues.springmongo.services;

import com.zaqueurodrigues.springmongo.domain.Post;
import com.zaqueurodrigues.springmongo.domain.User;
import com.zaqueurodrigues.springmongo.dto.UserDto;
import com.zaqueurodrigues.springmongo.repository.PostRepository;
import com.zaqueurodrigues.springmongo.repository.UserRepository;
import com.zaqueurodrigues.springmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;


	public Post findByID(String id){
		Optional<Post> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Post not exists!"));

	}

}
