package com.zaqueurodrigues.springmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.zaqueurodrigues.springmongo.domain.User;
import com.zaqueurodrigues.springmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria da Silva", "maria@gmail.com");
		User alex = new User(null, "Alex Pereira", "alex@gmail.com");
		User zaqueu = new User(null, "Zaqueu Rodrigues", "zakeurodrigues@outlook.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, zaqueu));
		
	}

}
