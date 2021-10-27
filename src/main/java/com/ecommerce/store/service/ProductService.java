package com.ecommerce.store.service;

import com.ecommerce.store.data.ProductDto;
import com.ecommerce.store.data.model.Product;
import com.ecommerce.store.web.exceptions.ProductDoesNotExistException;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    List<Product> findAll();

    Product findById(Long id);

    void deleteById(Long id);
    Product update(Long productId, ProductDto productDto) throws ProductDoesNotExistException;
}
