package com.ecommerce.store.service;

import com.ecommerce.store.data.ProductDto;
import com.ecommerce.store.data.model.Product;
import com.ecommerce.store.data.repository.ProductRepository;
import com.ecommerce.store.mapper.ProductMapper;
import com.ecommerce.store.web.exceptions.ProductDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

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
    public Product update(Long productId, ProductDto productDto) throws ProductDoesNotExistException {
        if(productDto == null){
            throw new NullPointerException("Product Dto can not be null");
        }
        Product product = new Product();
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isPresent()){
            productMapper.mapDtoToProduct(productDto, product);
            return productRepository.save(product);
        }
        else {
            throw new ProductDoesNotExistException("Product with id " + productId + " doesn't exist");
        }
    }

}
