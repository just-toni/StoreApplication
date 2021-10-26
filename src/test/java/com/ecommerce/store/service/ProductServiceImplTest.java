package com.ecommerce.store.service;

import com.ecommerce.store.data.model.Product;
import com.ecommerce.store.data.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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
    void saveProductMockTest() {
        Product product = new Product();
        when(productRepository.save(product)).thenReturn(product);
        productServiceImpl.save(product);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void findProductByIdMockTest(){
        Product product = new Product();
        product.setName("Prototype");
        product.setId(19L);
        when(productRepository.findById(19L)).thenReturn(Optional.of(product));
        Product product1 = productServiceImpl.findById(product.getId());
        verify(productRepository, times(1)).findById(19L);
        assertThat(product1).isNotNull();
        assertThat(product1.getId()).isEqualTo(product.getId());
        assertThat(product1.getName()).isEqualTo(product.getName());
    }
    
    @Test
    void updateProductMockTest(){
        Product product = new Product();
        product.setName("Dummy product");
        product.setId(20L);
        when(productRepository.findById(10L)).thenReturn(Optional.of(product));
        productServiceImpl.updateProduct(product, 10L);
        verify(productRepository, times(1)).save(product);
        assertEquals("Dummy product", product.getName());
        assertThat("Dummy product").isEqualTo(product.getName());
    }

}