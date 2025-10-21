package com.ingedwin.springboot.di.app.springboot_di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import com.ingedwin.springboot.di.app.springboot_di.interfaces.ProductRepositoryInterface;
import com.ingedwin.springboot.di.app.springboot_di.repositories.ProductRepositoryJSON;

@SpringBootApplication
@PropertySource("values.properties")
public class SpringbootDiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDiApplication.class, args);
	}

	@Value("classpath:jsons/product.json")
	private Resource resource;

	@Bean
	@Primary 
	ProductRepositoryInterface productRepositoryJSON(){
		return new ProductRepositoryJSON();
	}

}
