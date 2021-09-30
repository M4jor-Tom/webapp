package com.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entities.Product;
import com.boot.repositories.ProductRepository;

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
	public Iterable<Product> listAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
