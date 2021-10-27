package com.ecommerce.store.service;

import com.ecommerce.store.data.ProductDto;
import com.ecommerce.store.data.model.Product;
import com.ecommerce.store.data.repository.ProductRepository;
import com.ecommerce.store.web.exceptions.ProductDoesNotExistException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Sql(scripts = {"/db/insert.sql"})
class ProductServiceImplTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productServiceImpl;

    @Test
    void updateProductTest() throws ProductDoesNotExistException {
        Product product = productRepository.findById(10L).orElse(null);
        assertThat(product).isNotNull();
        assertThat(product.getName()).isEqualTo("Luxury Chair");

        ProductDto productDto = new ProductDto();
        productDto.setName("Mexican Chair");

        product = productServiceImpl.update(10L, productDto);
        assertThat(product.getName()).isEqualTo(productDto.getName());
    }

}