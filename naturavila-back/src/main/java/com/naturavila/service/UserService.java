package com.naturavila.service;

import java.util.Optional;

import com.naturavila.entity.UserEntity;
import com.naturavila.exception.NaturavilaException;

public interface UserService {

	UserEntity saveUser(UserEntity user) throws NaturavilaException;
	
	Optional<UserEntity> findById(Long id);

}
