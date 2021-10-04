package com.boot.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.boot.domain.DomainObject;

public interface EntityController<T extends DomainObject> {
	public String list(Model model);

	public String show(@PathVariable Integer id, Model model);

	public String edit(@PathVariable Integer id, Model model);

	public String newObject(Model model);

	public String save(DomainObject domainObject);

	public String delete(@PathVariable Integer id);
}