package com.boot.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entities.Role;
import com.boot.repositories.RoleRepository;
import com.boot.services.RoleService;

import javassist.NotFoundException;

@Service
public class RoleServiceImpl implements RoleService {

	private RoleRepository roleRepository;
	
	private RoleRepository getRoleRepository() {
		return roleRepository;
	}

	@Autowired
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public List<?> listAll() {
		return (List<?>) getRoleRepository().findAll();
	}

	@Override
	public Role getById(Integer id) {
		return getRoleRepository().findById(id).get();
	}

	@Override
	public Role saveOrUpdate(Role domainObject) {
		return getRoleRepository().save(domainObject);
	}

	@Override
	public void delete(Integer id) {
		getRoleRepository().deleteById(id);
	}

	@Override
	public Role findRoleByName(String rolename) throws NotFoundException {
		for(Role role: getRoleRepository().findAll())
		{
			if(role.getRole().equalsIgnoreCase(rolename))
			{
				return role;
			}
		}
		
		throw new NotFoundException("Role not found: " + rolename);
	}
}