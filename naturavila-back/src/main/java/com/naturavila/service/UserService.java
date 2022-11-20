package com.naturavila.service;

import com.naturavila.entity.User;
import com.naturavila.exception.NaturavilaException;

public interface UserService {

	User saveUser(User user) throws NaturavilaException;

}
