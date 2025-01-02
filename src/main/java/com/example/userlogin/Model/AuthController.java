package com.example.userlogin.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final UserService userservice;

	public AuthController(UserService userservice) {
		this.userservice = userservice;
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody RegistrationRequest request) {
		//TODO: process POST request
		
		userservice.registerUser(request.getUsername(), request.getPassword(), Role.USER);
		
		return ResponseEntity.ok("User registered successfully!!!");
	}
	
	
}
