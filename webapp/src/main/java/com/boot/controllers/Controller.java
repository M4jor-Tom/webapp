package com.boot.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.boot.domain.AbstractDomainClass;
import com.boot.services.CRUDService;

public interface Controller<T extends AbstractDomainClass> {
	public String list(Model model);

	public String show(@PathVariable Integer id, Model model);

	public String edit(@PathVariable Integer id, Model model);

	public String newObject(Model model);

	public String save(AbstractDomainClass object);

	public CRUDService<T> getCRUDService();

	public void setService(CRUDService<T> crudService);

	public String delete(@PathVariable Integer id);
}