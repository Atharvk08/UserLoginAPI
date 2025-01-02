package com.example.userlogin.Model;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepository repository;

	UserService(UserRepository repository) {
		this.repository = repository;
	}

	public void registerUser(String username, String password, Role role) {
		if (repository.findByUsername(username) != null) {
			throw new RuntimeException("User already exists!");
		}

		User user = new User();
		user.setUsername(username);
//		user encoding
		user.setPassword(password);
		user.setRole(role);

		repository.save(user);
	}

}
