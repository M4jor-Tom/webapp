package com.boot.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.boot.domain.AbstractDomainClass;

public interface IController<T extends AbstractDomainClass> {
	public String list(Model model);

	public String show(@PathVariable Integer id, Model model);

	public String edit(@PathVariable Integer id, Model model);

	public String newObject(Model model);

	public String save(AbstractDomainClass object);

	public String delete(@PathVariable Integer id);
}