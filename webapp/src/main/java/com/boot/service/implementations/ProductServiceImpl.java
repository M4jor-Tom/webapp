package com.boot.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entities.Product;
import com.boot.repositories.ProductRepository;
import com.boot.service.ProductService;

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
		return getProductRepository().findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		return getProductRepository().findById(id).get();
	}

	@Override
	public Product saveProduct(Product product) {
		return getProductRepository().save(product);
	}

	@Override
	public void deleteProduct(Integer id) {
		getProductRepository().deleteById(id);
	}

}
