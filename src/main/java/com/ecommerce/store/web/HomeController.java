package com.ecommerce.store.web;

import com.ecommerce.store.data.model.Product;
import com.ecommerce.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class HomeController {
    @Autowired
    ProductService productServiceImpl;

    @GetMapping("/index")
    public String getIndex(Model model){
        List<Product> productList = productServiceImpl.findAll();
        model.addAttribute("products", productList);
        return "index";
    }

    @GetMapping("/about")
    public String getAbout(){
        return "about";
    }

    @GetMapping("/contact")
    public String getContact(){
        return "contact";
    }
    @GetMapping("/products")
    public String getProduct(){
        return "product";
    }
    @GetMapping("/services")
    public String getServices(){
        return "services";
    }
    @GetMapping("/single")
    public String getsingle(){
        return "single";
    }
}
