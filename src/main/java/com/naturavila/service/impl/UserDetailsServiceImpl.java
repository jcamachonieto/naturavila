package com.naturavila.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.naturavila.entity.UserEntity;
import com.naturavila.mapper.UserMapper;
import com.naturavila.repository.UserRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByIdentifier(userId)
            .orElseThrow(() -> new UsernameNotFoundException("User NOT Found"));
        return UserMapper.userToPrincipal(user);
    }
	
}
