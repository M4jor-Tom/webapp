package com.boot.service;

import com.boot.entities.User;

import javassist.NotFoundException;

public interface UserService extends CRUDService<User> {
	User findByUsername(String username) throws NotFoundException;
}