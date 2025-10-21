package com.ingedwin.springboot.di.app.springboot_di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.ingedwin.springboot.di.app.springboot_di.interfaces.ProductRepositoryInterface;
import com.ingedwin.springboot.di.app.springboot_di.repositories.ProductRepositoryJSON;

@SpringBootApplication
@PropertySource("values.properties")
public class SpringbootDiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDiApplication.class, args);
	}

	@Bean
	@Primary 
	ProductRepositoryInterface productRepositoryJSON(){
		return new ProductRepositoryJSON();
	}

}
