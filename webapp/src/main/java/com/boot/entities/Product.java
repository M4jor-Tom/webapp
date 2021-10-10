package com.boot.entities;

import javax.persistence.Entity;

import jpaentitor.entities.AbstractEntity;

@Entity
public class Product extends AbstractEntity {
    private String productId;
    private String description;
    private String imageUrl;
    private float price;
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
