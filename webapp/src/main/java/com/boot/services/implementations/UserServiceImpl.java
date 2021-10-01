package com.boot.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.entities.User;
import com.boot.repositories.UserRepository;
import com.boot.services.UserService;
import com.boot.services.security.EncryptionService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private EncryptionService encryptionService;

	private EncryptionService getEncryptionService() {
		return encryptionService;
	}

	@Autowired
	private void setEncryptionService(EncryptionService encryptionService) {
		this.encryptionService = encryptionService;
	}

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
    public User saveOrUpdate(User domainObject) {
        if(domainObject.getPassword() != null){
            domainObject.setEncryptedPassword(getEncryptionService().encryptString(domainObject.getPassword()));
        }
        return getUserRepository().save(domainObject);
    }
	
	@Transactional
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
		
		throw new UsernameNotFoundException("User not found: " + username);
	}
}