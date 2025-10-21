package com.ingedwin.springboot.di.app.springboot_di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ingedwin.springboot.di.app.springboot_di.interfaces.ProductRepositoryInterface;
import com.ingedwin.springboot.di.app.springboot_di.models.Product;

public class ProductRepositoryJSON implements ProductRepositoryInterface{

    private List<Product> list;

    public ProductRepositoryJSON(){
        Resource resource = new ClassPathResource("jsons/product.json");
        ObjectMapper objMapper = new ObjectMapper();
        try {
            list = Arrays.asList(objMapper.readValue(resource.getFile(), Product[].class));
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return list.stream().filter(p -> 
            p.getId().equals(id)   
        ).findFirst().orElseThrow();
    }
    
}
