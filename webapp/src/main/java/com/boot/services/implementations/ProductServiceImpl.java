package com.boot.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entities.Product;
import com.boot.repositories.ProductRepository;
import com.boot.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private ProductRepository productRepository;
	
	private ProductRepository getProductRepository() {
		return productRepository;
	}

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> listAll() {
		return (List<Product>) getProductRepository().findAll();
	}

	@Override
	public Product getById(Integer id) {
		return getProductRepository().findById(id).get();
	}

	@Override
	public Product saveOrUpdate(Product product) {
		return getProductRepository().save(product);
	}

	@Override
	public void delete(Integer id) {
		getProductRepository().deleteById(id);
	}
}
