package com.craftsman.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class FrontViewApp{

	public static void main(String[] args) {
		SpringApplication.run(FrontViewApp.class, args);
	}

}
