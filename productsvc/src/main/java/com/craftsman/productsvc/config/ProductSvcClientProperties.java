package com.craftsman.productsvc.config;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URI;

@ConfigurationProperties(prefix = "client")
public record ProductSvcClientProperties(
        @NotNull
        URI webservice
) {
}
