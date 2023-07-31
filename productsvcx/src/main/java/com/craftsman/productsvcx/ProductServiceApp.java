package com.craftsman.productsvcx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(proxyBeanMethods = false)
@ConfigurationPropertiesScan
public class ProductServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApp.class, args);
	}
}
