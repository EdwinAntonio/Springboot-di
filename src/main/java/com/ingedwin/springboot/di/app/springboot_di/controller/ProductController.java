package com.ingedwin.springboot.di.app.springboot_di.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingedwin.springboot.di.app.springboot_di.models.Product;
import com.ingedwin.springboot.di.app.springboot_di.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> list(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductId(@PathVariable Long id) {
        try {
            return this.productService.findById(id);
        } catch (NullPointerException e) {
            return new Product(0L, "No existe Producto", 0L);
        }
    }
    
}
