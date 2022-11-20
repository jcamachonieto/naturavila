package com.naturavila.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naturavila.entity.User;
import com.naturavila.exception.NaturavilaException;
import com.naturavila.repository.UserRepository;
import com.naturavila.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) throws NaturavilaException {
		if (userRepository.findByIdentifier(user.getIdentifier()) != null) {
			throw new NaturavilaException("User exists");
		} else {
			return userRepository.save(user);
		}
	}

}
