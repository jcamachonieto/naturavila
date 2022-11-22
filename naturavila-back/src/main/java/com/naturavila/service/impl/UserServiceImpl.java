package com.naturavila.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
	public UserEntity findById(Long id) throws NaturavilaException {
		Optional<UserEntity> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new NaturavilaException("User not found with ID :" + id);
		}
		return user.get();
	}

	@Override
	public UserEntity findByIdentifier(String identifier) throws NaturavilaException {
		UserEntity user = userRepository.findByIdentifier(identifier)
	            .orElseThrow(() -> new UsernameNotFoundException("User NOT Found by identifier:" + identifier));
		return user;
	}

	@Override
	public List<UserEntity> findAll() {
		return userRepository.findAll();
	}

}
