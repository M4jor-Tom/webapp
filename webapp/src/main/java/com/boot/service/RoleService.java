package com.boot.service;

import com.boot.entities.Role;

import javassist.NotFoundException;

public interface RoleService extends CRUDService<Role> {
	Role findRoleByName(String rolename) throws NotFoundException;
}