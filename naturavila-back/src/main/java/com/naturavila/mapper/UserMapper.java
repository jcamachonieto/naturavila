package com.naturavila.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.naturavila.entity.UserEntity;
import com.naturavila.model.UserPrincipal;

public class UserMapper {

	public static UserPrincipal userToPrincipal(UserEntity user) {
		UserPrincipal userp = new UserPrincipal();
		List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoleName())).collect(Collectors.toList());
		userp.setUsername(user.getIdentifier());
		userp.setPassword(user.getPassword());
		userp.setEnabled(user.getEnabled());
		userp.setAuthorities(authorities);
		return userp;
	}

}
