package com.naturavila.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@PostMapping("/user/addManager")
	@PreAuthorize("hasAnyRole('ADMIN')")
	ResponseEntity<UserEntity> addUser(@Valid @RequestBody UserEntity user) throws NaturavilaException {
		// persisting the user
		user.setRole(roleService.findByRoleName(RoleName.MANAGER));
		UserEntity userDB = userService.saveUser(user);
		return ResponseEntity.ok(userDB);
	}
	
	@GetMapping(value = "/user")
	@PreAuthorize("hasAnyRole('ADMIN')")
    ResponseEntity<List<UserEntity>> findAll() throws NaturavilaException {
        return ResponseEntity.ok(userService.findAll());
    }
	
    @GetMapping(value = "/user/{id}")
    ResponseEntity<UserEntity> findById(@PathVariable("id") @Min(1) Long id) throws NaturavilaException {
        return ResponseEntity.ok(userService.findById(id));
    }
	
	@PutMapping("/user/{id}")
	@PreAuthorize("hasAnyRole('USER')")
	ResponseEntity<UserEntity> updateUser(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody UserEntity user) throws NaturavilaException {
		// persisting the user
		UserEntity userDB = userService.findById(id);
		user.setId(userDB.getId());
		return ResponseEntity.ok(userService.saveUser(user));
	}

}
