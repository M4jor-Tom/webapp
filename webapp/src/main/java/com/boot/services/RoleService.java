package com.boot.services;

import com.boot.entities.Role;

import javassist.NotFoundException;

public interface RoleService extends CRUDService<Role> {
	Role findRoleByName(String rolename) throws NotFoundException;
}