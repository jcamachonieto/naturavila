package com.naturavila.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naturavila.config.RoleName;
import com.naturavila.entity.UserEntity;
import com.naturavila.exception.NaturavilaException;
import com.naturavila.service.RoleService;
import com.naturavila.service.UserService;

@RestController
@RequestMapping("/protected")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;

	@PostMapping("/addManager")
	@PreAuthorize("hasAnyRole('ADMIN')")
	ResponseEntity<UserEntity> addUser(@Valid @RequestBody UserEntity user) throws NaturavilaException {
		// persisting the user
		user.setRole(roleService.findByRoleName(RoleName.MANAGER));
		UserEntity userDB = userService.saveUser(user);
		return ResponseEntity.ok(userDB);
	}

}
