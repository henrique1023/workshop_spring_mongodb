package com.henrique.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.henrique.workshopmongo.domain.User;
import com.henrique.workshopmongo.repository.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		User u1 = new User(null, "maria", "xxx@gmail.com");
		User u2 = new User(null, "João", "xxx@gmail.com");
		User u3 = new User(null, "Felipe", "xxx@gmail.com");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
	}

}
