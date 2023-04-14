package com.craftsman.catalogsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class CatalogServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(CatalogServiceApp.class, args);
	}
}
