package com.boot.forms;

import com.boot.entities.Product;

public class ProductForm {

    private String productId;
    private String description;
    private String imageUrl;
    private float price;
    
    public ProductForm()
    {
    	this("", "", "", (float)0.0);
    }
    
    public ProductForm(Product product)
    {
    		this(
    			product.getProductId(),
    			product.getDescription(),
    			product.getImageUrl(),
    			product.getPrice()
    		);
    }
    
    public ProductForm(String productId, String description, String imageUrl, float price) {
		super();
		setProductId(productId);
		setDescription(description);
		setImageUrl(imageUrl);
		setPrice(price);
	}

	public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
}
