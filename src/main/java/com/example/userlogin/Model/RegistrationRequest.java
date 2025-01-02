package com.example.userlogin.Model;

import lombok.Data;

// Data transfer object for registration request

@Data
public class RegistrationRequest {

	private String username;
	private String password;
}
