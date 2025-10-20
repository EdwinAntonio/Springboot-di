package com.ingedwin.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ingedwin.springboot.di.app.springboot_di.interfaces.ProductRepositoryInterface;
import com.ingedwin.springboot.di.app.springboot_di.models.Product;

/*
 * El implements que hace referencia hacia una interfaz es una estructura OBLIGADA que los repositorios 
 * deben de Si o Si implementarlas en sus metodos y pueden tener de manera opcional el @Override arriba
 * de cada metodo creado que cumpla con TODOS los metodos de la interfaz
 */

 @Component
public class ProductRepository implements ProductRepositoryInterface {
    
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

    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(null);
    }

}
