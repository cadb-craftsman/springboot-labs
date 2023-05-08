package com.craftsman.catalogsvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class CatalogSvcClientConfig {

	@Bean
	WebClient webClient(CatalogSvcClientProperties clientProperties, WebClient.Builder webClientBuilder) {
		return webClientBuilder
				.baseUrl(clientProperties.webservice().toString())
				.build();
	}

}
