package com.boot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.boot.entities.Product;
public interface ProductRepository extends CrudRepository<Product, Integer>{
}