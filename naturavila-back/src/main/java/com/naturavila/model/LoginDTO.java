package com.naturavila.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginDTO {

	@NotBlank(message = "userId is mandatory")
	private String userId;
	
	@NotBlank(message = "password is mandatory")
	private String password;
	
}
