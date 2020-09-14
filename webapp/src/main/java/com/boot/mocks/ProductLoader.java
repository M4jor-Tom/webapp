package com.boot.mocks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.boot.entities.Product;
import com.boot.repositories.ProductRepository;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;

    private Logger log = LoggerFactory.getLogger(ProductLoader.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Product shirt = new Product();
        shirt.setDescription(" Chemise Lacouste");
        shirt.setPrice(18.95f);
        shirt.setImageUrl("https://www.vision-naire.com/wp-content/uploads/2016/11/T-SHIRT-V-150x150.jpg");
        shirt.setProductId("235268845711068308");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription("Pantalon Hugo Boot");
        mug.setImageUrl("https://www.vision-naire.com/wp-content/uploads/2020/06/jogging-visionnaire-2-100x100.jpg");
        mug.setProductId("168639393495335947");
        productRepository.save(mug);

        log.info("Saved Pant - id:" + mug.getId());
    }
}
