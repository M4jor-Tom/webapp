package com.boot.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import jpaentitor.entities.Primable;

public interface EntityController<T extends Primable> {
	public String list(Model model);

	public String show(@PathVariable Integer id, Model model);

	public String edit(@PathVariable Integer id, Model model);

	public String newObject(Model model);

	public String save(Primable primable);

	public String delete(@PathVariable Integer id);
}