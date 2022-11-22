package com.naturavila.service;

import java.util.List;

import com.naturavila.entity.UserEntity;
import com.naturavila.exception.NaturavilaException;

public interface UserService {

	UserEntity saveUser(UserEntity user) throws NaturavilaException;
	
	UserEntity findById(Long id) throws NaturavilaException;
	
	UserEntity findByIdentifier(String identifier) throws NaturavilaException;
	
	List<UserEntity> findAll();

}
