package com.boot.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.boot.entities.User;

import crudservice.CrudService;

public interface UserService extends CrudService<User> {
	User findByUsername(String username) throws UsernameNotFoundException;
}