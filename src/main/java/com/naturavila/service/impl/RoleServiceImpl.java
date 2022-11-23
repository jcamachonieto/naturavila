package com.naturavila.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naturavila.config.RoleName;
import com.naturavila.entity.RoleEntity;
import com.naturavila.repository.RoleRepository;
import com.naturavila.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public RoleEntity findByRoleName(RoleName rolName) {
		return roleRepository.findByRoleName(rolName);
	}

}
