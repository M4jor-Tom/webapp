package com.boot.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;

import com.boot.entities.User;
import com.boot.repositories.UserRepository;
import com.boot.service.UserService;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	private UserRepository getUserRepository() {
		return userRepository;
	}

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public Iterable<User> listAllUsers() {
		return getUserRepository().findAll();
	}

	@Override
	public User getUserById(Integer id) {
		return getUserRepository().findById(id).get();
	}

	@Override
	public User saveUser(User user) {
		return getUserRepository().save(user);
	}

	@Override
	public void deleteUser(Integer id) {
		getUserRepository().deleteById(id);
	}

}