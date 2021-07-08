package com.zaqueurodrigues.springmongo.services;

import java.util.List;
import java.util.Optional;

import com.zaqueurodrigues.springmongo.dto.UserDto;
import com.zaqueurodrigues.springmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaqueurodrigues.springmongo.domain.User;
import com.zaqueurodrigues.springmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}

	public User findByID(String id){
		Optional<User> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("User not exists!"));

	}

	public User insert(User obj){
		return repo.insert(obj);
	}

	public void delete(String id){
		findByID(id);
		repo.deleteById(id);
	}

	public User update(User obj){
		User newObj = findByID(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void updateData(User newObj, User obj){
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDto (UserDto objDto){
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
