package com.boot.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.boot.entities.Role;
import com.boot.repositories.RoleRepository;
import com.boot.service.RoleService;

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
}