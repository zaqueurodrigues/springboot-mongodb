package com.zaqueurodrigues.springmongo.resources;

import com.zaqueurodrigues.springmongo.domain.Post;
import com.zaqueurodrigues.springmongo.domain.User;
import com.zaqueurodrigues.springmongo.dto.UserDto;
import com.zaqueurodrigues.springmongo.services.PostService;
import com.zaqueurodrigues.springmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService service;

	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findByID(id);

		return ResponseEntity.ok().body(obj);
	}

}