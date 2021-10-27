package com.ecommerce.store.web.controller;

import com.ecommerce.store.data.model.Product;
import com.ecommerce.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ProductService productServiceImpl;

    @GetMapping(value = "/index1")
    public String getIndex(Model model) {
        List<Product> productList = productServiceImpl.findAll();
        model.addAttribute("products", productList);
        return "index1";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "about";
    }

    @GetMapping("/contact")
    public String getContact() {
        return "contact";
    }

    @GetMapping("/products")
    public String getProduct() {
        return "product";
    }

    @GetMapping("/services")
    public String getServices() {
        return "services";
    }

    @GetMapping("/single")
    public String getsingle() {
        return "single";
    }
}
