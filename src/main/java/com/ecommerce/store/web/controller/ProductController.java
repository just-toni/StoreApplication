package com.ecommerce.store.web.controller;

import com.ecommerce.store.data.ProductDto;
import com.ecommerce.store.data.model.Product;
import com.ecommerce.store.service.ProductService;
import com.ecommerce.store.web.exceptions.ProductDoesNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {

    ProductService productServiceImpl;

    @Autowired
    public ProductController(ProductService productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    @GetMapping("/findAllProducts/")
    public List<Product> findAll() {
        return productServiceImpl.findAll();
    }

    @PostMapping("/add/")
    public Product add(@RequestBody Product product) {
        log.info("Product request --> {}", product);
        return productServiceImpl.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productServiceImpl.deleteById(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Long id) {
        productServiceImpl.findById(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        log.info("Request id --> {}", id);
        log.info("Product dto details --> {}", productDto);
        Product product = null;
        try {
            product = productServiceImpl.update(id, productDto);

        } catch (ProductDoesNotExistException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.ok().body(product);
    }
}