package com.henrique.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henrique.workshopmongo.domain.User;
import com.henrique.workshopmongo.dto.UserDTO;
import com.henrique.workshopmongo.repository.UserRepository;
import com.henrique.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}

	public User insert(User obj) {
		return repository.insert(obj);
	}

	public User fromDTO(UserDTO objdto) {
		return new User(objdto.getId(), objdto.getName(), objdto.getEmail());
	}

	public void deleteById(String id) {
		repository.deleteById(id);
	}

	public User update(User obj) {
		Optional<User> newObj = repository.findById(obj.getId());
		User u = updateData(newObj, obj);
		return repository.save(u);
	}

	private User updateData(Optional<User> newObj, User obj) {
		if (newObj.isPresent()) {
			newObj.get().setEmail(obj.getEmail());
			newObj.get().setName(obj.getName());
			User user = newObj.get();
			return user;
		}
		throw new ObjectNotFoundException("Objeto não existe no banco");
		
	}
}
