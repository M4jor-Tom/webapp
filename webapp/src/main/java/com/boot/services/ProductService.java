package com.boot.services;

import com.boot.entities.Product;
/**
 * Aucune interraction avec la BDD. 
 * Découplage complet
 *
 */
public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}
