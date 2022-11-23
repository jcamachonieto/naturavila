package com.naturavila.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naturavila.config.JwtProvider;
import com.naturavila.model.LoginDTO;

@RestController
@RequestMapping("/public")
public class LoginController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtProvider tokenProvider;

	@PostMapping("/login")
	public ResponseEntity<String> authenticateUser(@Valid @RequestBody LoginDTO login) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(login.getUserId(), login.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok(jwt);
	}

}
