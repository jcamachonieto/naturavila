package com.naturavila.service;

import com.naturavila.config.RoleName;
import com.naturavila.entity.RoleEntity;

public interface RoleService {

	RoleEntity findByRoleName(RoleName rolName);

}
