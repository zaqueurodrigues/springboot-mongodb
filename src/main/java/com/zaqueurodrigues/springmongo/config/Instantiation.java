package com.zaqueurodrigues.springmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import com.zaqueurodrigues.springmongo.domain.Post;
import com.zaqueurodrigues.springmongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.zaqueurodrigues.springmongo.domain.User;
import com.zaqueurodrigues.springmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria da Silva", "maria@gmail.com");
		User alex = new User(null, "Alex Pereira", "alex@gmail.com");
		User zaqueu = new User(null, "Zaqueu Rodrigues", "zakeurodrigues@outlook.com");

		Post post1 = new Post(null, sdf.parse("03/11/2020"), "Partiu viagem!", "Vou viajar para a Bahia", zaqueu);
		Post post2 = new Post(null, sdf.parse("05/05/2019"), "Good Morning!", "Hi guys, how are u?", maria);

		userRepository.saveAll(Arrays.asList(maria, alex, zaqueu));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
