package com.naturavila.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.naturavila.entity.UserEntity;
import com.naturavila.exception.NaturavilaException;
import com.naturavila.repository.UserRepository;
import com.naturavila.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserEntity saveUser(UserEntity user) throws NaturavilaException {
		if (userRepository.findByIdentifier(user.getIdentifier()).isEmpty()) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return userRepository.save(user);
		} else {
			throw new NaturavilaException("User exists");
		}
	}

	@Override
	public Optional<UserEntity> findById(Long id) {
		return userRepository.findById(id);
	}

}
