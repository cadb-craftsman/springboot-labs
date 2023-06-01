package com.craftsman.productsvcx.config;

import java.time.Duration;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.craftsman.productsvcx.domain.model.dto.ProductSvcDto;

import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

public class ProductSvcClient {
	private static final String RESTSERVICE_API = "/api/v1/reactservice/";
	private final WebClient webClient;

	public ProductSvcClient(WebClient webClient) {
		this.webClient = webClient;
	}

	public Mono<ProductSvcDto> getMethodName(Long id) {
		return webClient.get().uri(RESTSERVICE_API + id).retrieve().bodyToMono(ProductSvcDto.class)
				.timeout(Duration.ofSeconds(3), Mono.empty())
				.onErrorResume(WebClientResponseException.NotFound.class, exception -> Mono.empty())
				.retryWhen(Retry.backoff(3, Duration.ofMillis(100)))
				.onErrorResume(Exception.class, exception -> Mono.empty());
	}

}
