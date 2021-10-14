package com.ecommerce.store.service;

import com.ecommerce.store.data.model.Product;
import com.ecommerce.store.data.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;
    @InjectMocks
    ProductService productServiceImpl;

    @BeforeEach
    void setUp() {
        productServiceImpl = new ProductServiceImpl();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveProductMockTest(){
        Product product = new Product();
        when(productServiceImpl.save(product)).thenReturn(product);
        productServiceImpl.save(product);
        verify(productRepository, times(1)).save(product);
    }

}