package com.naturavila.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.naturavila.entity.UserEntity;
import com.naturavila.model.UserPrincipal;

public class UserMapper {

	public static UserPrincipal userToPrincipal(UserEntity user) {
		UserPrincipal userp = new UserPrincipal();
		userp.setUsername(user.getIdentifier());
		userp.setPassword(user.getPassword());
		userp.setEnabled(user.getEnabled());
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName()));
		userp.setAuthorities(authorities);
		return userp;
	}

}
