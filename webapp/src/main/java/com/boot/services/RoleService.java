package com.boot.services;

import com.boot.entities.Role;

import crudity.services.CrudService;
import javassist.NotFoundException;

public interface RoleService extends CrudService<Role> {
	Role findRoleByName(String rolename) throws NotFoundException;
}