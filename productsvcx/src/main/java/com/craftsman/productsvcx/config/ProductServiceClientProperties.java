package com.craftsman.productsvcx.config;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URI;

@ConfigurationProperties(prefix = "client")
public record ProductServiceClientProperties(
        @NotNull
        URI webservice
) {
}
