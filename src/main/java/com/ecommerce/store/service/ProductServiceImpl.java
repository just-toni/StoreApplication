package com.ecommerce.store.service;

import com.ecommerce.store.data.model.Product;
import com.ecommerce.store.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void updateProduct(Product product, Long productId){
//        Optional<Product> productOptional = productRepository.findById(productId);
//        if(productOptional.isPresent()){
//            product.setName(product.getName());
//            product.setPrice(product.getPrice());
//            product.setDetails(product.getDetails());
//            product.setCurrency(product.getCurrency());
//            product.setImageUrl(product.getImageUrl());
//            productRepository.save(product);
        product = findById(productId);
        if(product.getName() == null){
            product.setName(product.getName());
        }
        if(product.getPrice() == null){
            product.setPrice(product.getPrice());
        }
        if (product.getCurrency() == null) {
            product.setCurrency(product.getCurrency());
        }
        if(product.getDetails() == null){
            product.setDetails(product.getDetails());
        }
        if(product.getImageUrl() == null){
            product.setImageUrl(product.getImageUrl());
        }
        productRepository.save(product);
    }
}
