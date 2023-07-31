package com.craftsman.frontend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class FrontViewClientConfig {

	@Bean
	WebClient webClient(FrontViewClientProperties clientProperties, WebClient.Builder webClientBuilder) {
		return webClientBuilder
				.baseUrl(clientProperties.webservice().toString())
				.build();
	}

}
