package com.ingedwin.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import com.ingedwin.springboot.di.app.springboot_di.models.Product;

public class ProductRepository {
    
    private List<Product> data;

    public ProductRepository(){
        this.data =  Arrays.asList(
            new Product(1L, "Memoria", 300L),
            new Product(2L, "CPU", 400L),
            new Product(3L, "Teclado", 500L),
            new Product(4L, "Monitor", 600L)
            );
    }

    public List<Product> findAll(){
        return data;
    }

    public Product finByiD(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(null);
    }

}
