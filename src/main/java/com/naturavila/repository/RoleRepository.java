package com.naturavila.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naturavila.config.RoleName;
import com.naturavila.entity.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long>{

	RoleEntity findByRoleName(RoleName roleName);
	
}
