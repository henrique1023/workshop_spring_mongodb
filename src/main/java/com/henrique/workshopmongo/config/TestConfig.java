package com.henrique.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.henrique.workshopmongo.domain.Post;
import com.henrique.workshopmongo.domain.User;
import com.henrique.workshopmongo.dto.AuthorDTO;
import com.henrique.workshopmongo.repository.PostRepository;
import com.henrique.workshopmongo.repository.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner{
	
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User u1 = new User(null, "maria", "xxx@gmail.com");
		User u2 = new User(null, "João", "xxx@gmail.com");
		User u3 = new User(null, "Felipe", "xxx@gmail.com");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		
		Post p1 = new Post(null, sdf.parse("25/03/2018"), "Partiu viagem", "Vou viajar!", new AuthorDTO(u1));
		Post p2 = new Post(null, sdf.parse("29/03/2018"), "Bom dia", "Acordei!", new AuthorDTO(u1));
		
		postRepository.saveAll(Arrays.asList(p1,p2));
	}

}
