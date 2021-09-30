package com.boot.service;

import com.boot.entities.Role;

public interface RoleService {
    Iterable<Role> listAllRoles();

    Role getRoleById(Integer id);

    Role saveRole(Role user);

    void deleteRole(Integer id);
}