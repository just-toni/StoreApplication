package com.ecommerce.store.data.repository;

import com.ecommerce.store.data.model.Currency;
import com.ecommerce.store.data.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Sql(scripts = {"/db/insert.sql"})
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepositoryImpl;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void createProductTest() {
        Product product = new Product();
        product.setName("Luxury Sofa");
        product.setPrice(400.00);
        product.setCurrency(Currency.USD);
        product.setDetails("Brown leather three seater luxury sofa");

        assertThat(product).isNotNull();
        assertThat(product.getId()).isNull();
        log.info("Product before saving -> {}", product);
        productRepositoryImpl.save(product);
        assertThat(product.getId()).isNotNull();
        log.info("Product after saving -> {}", product);

    }

    @Test
    @Transactional
    public void productListIsReturnedTest() {
        List<Product> products = productRepositoryImpl.findAll();
        assertThat(products).hasSize(4);
        log.info("Products returned from database -> {}", products);
    }

    @Test
    public void findExistingProductById() {
        Product existingProduct =
                productRepositoryImpl.findById(2L).orElse(null);
        assertThat(existingProduct).isNotNull();
        log.info("Product -> {}", existingProduct);
    }

    @Test
    public void deleteExistingProductById() {
        assertThat(productRepositoryImpl.findById(3L).orElse(null)).isNotNull();
        productRepositoryImpl.deleteById(3L);
        assertThat(productRepositoryImpl.findById(3L).orElse(null)).isNull();
    }
}