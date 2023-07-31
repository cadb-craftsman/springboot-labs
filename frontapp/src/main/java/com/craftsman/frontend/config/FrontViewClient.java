package com.craftsman.frontend.config;

import java.time.Duration;

import com.craftsman.frontend.domain.FrontViewDto;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;



import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

public class FrontViewClient {
	private static final String RESTSERVICE_API = "/api/v1/reactservice/";
	private final WebClient webClient;

	public FrontViewClient(WebClient webClient) {
		this.webClient = webClient;
	}

	public Mono<FrontViewDto> getMethodName(Long id) {
		return webClient.get().uri(RESTSERVICE_API + id).retrieve().bodyToMono(FrontViewDto.class)
				.timeout(Duration.ofSeconds(3), Mono.empty())
				.onErrorResume(WebClientResponseException.NotFound.class, exception -> Mono.empty())
				.retryWhen(Retry.backoff(3, Duration.ofMillis(100)))
				.onErrorResume(Exception.class, exception -> Mono.empty());
	}

}
