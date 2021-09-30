package com.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boot.entities.Product;
import com.boot.forms.ProductForm;
import com.boot.service.ProductService;

@Controller
public class ProductController {
	private ProductService productService;

	@RequestMapping(value = "products", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("products", productService.listAllProducts());
		return "products";
	}

	@RequestMapping(value = "product/show/{id}", method = RequestMethod.GET)
	public String showProduct(@PathVariable Integer id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "productshow";
	}

	@RequestMapping(value = "product/edit/{id}", method = RequestMethod.PUT)
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("product", new ProductForm());
		return "productform";
	}

	@RequestMapping(value = "product/new", method = RequestMethod.POST)
	public String newProduct(Model model) {
		model.addAttribute("product", new Product());
		return "productform";
	}

	@RequestMapping(value = "product", method = RequestMethod.POST)
	public String saveProduct(Product product) {
		productService.saveProduct(product);
		return "redirect:/product/show/" + product.getId();
	}

	private ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "product/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Integer id) {
		productService.deleteProduct(id);
		return "redirect:/products";
	}
}