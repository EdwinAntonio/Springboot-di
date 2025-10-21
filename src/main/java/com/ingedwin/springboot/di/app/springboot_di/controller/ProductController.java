package com.ingedwin.springboot.di.app.springboot_di.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingedwin.springboot.di.app.springboot_di.interfaces.ProductServiceInterface;
import com.ingedwin.springboot.di.app.springboot_di.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api")
public class ProductController {

    /*
     * En caso de tener una interfaz que este implementada a 2 clases diferentes, hay que usar la notacion
     * @Primary o @Qualifier en las clases que manden a llamar a esa interfaz, para darle una prioridad a 
     * cual de las 2 clases tomara como prioridad la interfaz que estamos injectando
     * 
     * @Autowired
     * @Qualifier("productServiceInterface")
     * 
     */

    @Autowired
    private ProductServiceInterface productService;

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
