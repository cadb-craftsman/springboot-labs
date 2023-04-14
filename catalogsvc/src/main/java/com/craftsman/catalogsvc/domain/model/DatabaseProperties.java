package com.craftsman.catalogsvc.domain.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "spring.datasource")
public class DatabaseProperties {
	
	private String url;
	private String driverClassName;
	private String username;
	private String password;
	private String path;

}
