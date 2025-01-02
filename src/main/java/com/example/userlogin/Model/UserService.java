package com.example.userlogin.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	final static Logger logger= LoggerFactory.getLogger(UserService.class);

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

		logger.info(user.toString());
		
		repository.save(user);
	}
	
    public void logUserDetails(String username) {
        User user = repository.findByUsername(username);
        if (user!=null) {
            logger.info("User details: {}", user.toString());
        } else {
            logger.warn("User not found with username: {}", username);
        }
    }

}
