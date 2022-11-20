package com.naturavila.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naturavila.entity.User;
import com.naturavila.exception.NaturavilaException;
import com.naturavila.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	ResponseEntity<User> addUser(@Valid @RequestBody User user) throws NaturavilaException {
		// persisting the user
		User userDB = userService.saveUser(user);
		return ResponseEntity.ok(userDB);
	}

}
