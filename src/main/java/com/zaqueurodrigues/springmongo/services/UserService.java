package com.zaqueurodrigues.springmongo.services;

import java.util.List;
import java.util.Optional;

import com.zaqueurodrigues.springmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaqueurodrigues.springmongo.domain.User;
import com.zaqueurodrigues.springmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAl() {
		return repo.findAll();
	}

	public User findByID(String id){
		Optional<User> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("User not exists!"));

	}

}
