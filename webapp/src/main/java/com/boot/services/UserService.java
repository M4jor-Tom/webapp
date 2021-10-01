package com.boot.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.boot.entities.User;

public interface UserService extends CRUDService<User> {
	User findByUsername(String username) throws UsernameNotFoundException;
}