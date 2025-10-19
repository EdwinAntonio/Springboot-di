package com.ingedwin.springboot.di.app.springboot_di.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {

    private Long id;
    private String name;
    private Long price;

}
