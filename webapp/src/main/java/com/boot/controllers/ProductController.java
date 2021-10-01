package com.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
		model.addAttribute("products", getProductService().listAll());
		return "products";
	}

	@RequestMapping(value = "product/show/{id}", method = RequestMethod.GET)
	public String showProduct(@PathVariable Integer id, Model model) {
		model.addAttribute("product", getProductService().getById(id));
		return "productshow";
	}

	@RequestMapping(value = "product/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, Model model) {
		Product product = getProductService().getById(id);
		model.addAttribute(
				"productform",
				new ProductForm(product)
			);
		return "productform";
	}

	@RequestMapping(value = "product/new", method = RequestMethod.GET)
	public String newProduct(Model model) {
		model.addAttribute(
				"productform",
				new ProductForm()
			);
		return "productform";
	}

	@RequestMapping(value = "product", method = RequestMethod.POST)
	public String saveProduct(Product product) {
		getProductService().saveOrUpdate(product);
		return "redirect:/product/show/" + product.getId();
	}

	private ProductService getProductService() {
		return productService;
	}

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "product/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Integer id) {
		getProductService().delete(id);
		return "redirect:/products";
	}
}