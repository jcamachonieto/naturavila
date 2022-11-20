package com.naturavila.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naturavila.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByIdentifier(String identifier);
	
}
