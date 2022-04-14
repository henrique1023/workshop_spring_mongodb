package com.henrique.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.henrique.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User joao = new User("1", "João", "joao@gmail.com");
		User merio = new User("2", "Merio", "joao@gmail.com");
		User cleber = new User("3", "Cleber", "joao@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(joao, merio, cleber));
		return ResponseEntity.ok().body(list);
	} 
}
