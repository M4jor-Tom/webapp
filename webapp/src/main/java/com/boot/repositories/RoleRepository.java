package com.boot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.boot.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

}