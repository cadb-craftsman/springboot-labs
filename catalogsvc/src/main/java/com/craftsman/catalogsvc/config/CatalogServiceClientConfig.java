package com.craftsman.catalogsvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class CatalogServiceClientConfig {

	@Bean
	WebClient webClient(CatalogServiceClientProperties clientProperties, WebClient.Builder webClientBuilder) {
		return webClientBuilder
				.baseUrl(clientProperties.webservice().toString())
				.build();
	}

}
