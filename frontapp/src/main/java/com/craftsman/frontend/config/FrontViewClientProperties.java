package com.craftsman.frontend.config;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URI;

@ConfigurationProperties(prefix = "client")
public record FrontViewClientProperties(
        @NotNull
        URI webservice
) {
}
