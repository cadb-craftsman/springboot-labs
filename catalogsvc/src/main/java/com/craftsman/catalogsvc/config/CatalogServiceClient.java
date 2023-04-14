package com.craftsman.catalogsvc.config;

import java.time.Duration;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.craftsman.catalogsvc.domain.dto.CatalogServiceDto;

import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

public class CatalogServiceClient {
	private static final String RESTSERVICE_API = "/api/v1/reactservice/";
	private final WebClient webClient;

	public CatalogServiceClient(WebClient webClient) {
		this.webClient = webClient;
	}

	public Mono<CatalogServiceDto> getMethodName(Long id) {
		return webClient.get().uri(RESTSERVICE_API + id).retrieve().bodyToMono(CatalogServiceDto.class)
				.timeout(Duration.ofSeconds(3), Mono.empty())
				.onErrorResume(WebClientResponseException.NotFound.class, exception -> Mono.empty())
				.retryWhen(Retry.backoff(3, Duration.ofMillis(100)))
				.onErrorResume(Exception.class, exception -> Mono.empty());
	}

}
