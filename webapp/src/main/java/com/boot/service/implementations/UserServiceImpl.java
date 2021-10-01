package com.boot.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boot.entities.User;
import com.boot.repositories.UserRepository;
import com.boot.service.UserService;

@Service
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
	public List<User> listAll() {
		return (List<User>) getUserRepository().findAll();
	}

	@Override
	public User getById(Integer id) {
		return getUserRepository().findById(id).get();
	}

	@Override
	public User saveOrUpdate(User user) {
		return getUserRepository().save(user);
	}

	@Override
	public void delete(Integer id) {
		getUserRepository().deleteById(id);
	}

	@Override
	public User findByUsername(String username) throws UsernameNotFoundException {
		for(User user: getUserRepository().findAll())
		{
			if(user.getUsername().equalsIgnoreCase(username))
			{
				return user;
			}
		}
		
		throw new UsernameNotFoundException("user: " + username);
	}
}