package com.ingedwin.springboot.di.app.springboot_di.interfaces;

import java.util.List;
import com.ingedwin.springboot.di.app.springboot_di.models.Product;

public interface ProductServiceInterface {

    List<Product> findAll();

    Product findById(Long id);
}
