package com.ecommerce.store.web;

import com.ecommerce.store.data.model.Product;
import com.ecommerce.store.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Product> save() {
        return productServiceImpl.findAll();
    }

    @PostMapping("/add/")
    public Product save(@RequestBody Product product) {
        log.info("Product request --> {}", product);
        return productServiceImpl.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productServiceImpl.deleteById(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Product product){
        log.info("Product request --> {}", product);
        productServiceImpl.updateProduct(product, product.getId());
        return ResponseEntity.ok("Product updated successfully");
    }
}
