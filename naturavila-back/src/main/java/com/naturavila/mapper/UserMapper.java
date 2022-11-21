package com.naturavila.mapper;

import com.naturavila.entity.User;
import com.naturavila.model.UserPrincipal;

public class UserMapper {

	public static UserPrincipal userToPrincipal(User user) {
        UserPrincipal userp = new UserPrincipal();
        // TODO
        /*List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
            .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName())).collect(Collectors.toList());*/

        userp.setUsername(user.getIdentifier());
        userp.setPassword(user.getPassword());
        userp.setEnabled(user.getEnabled());
        //userp.setAuthorities(authorities);
        return userp;
    }
	
}
