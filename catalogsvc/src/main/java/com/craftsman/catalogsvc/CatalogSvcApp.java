package com.craftsman.catalogsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class CatalogSvcApp {

	public static void main(String[] args) {
		SpringApplication.run(CatalogSvcApp.class, args);
	}
}
