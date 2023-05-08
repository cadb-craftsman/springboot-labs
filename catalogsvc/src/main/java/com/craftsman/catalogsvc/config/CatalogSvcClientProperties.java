package com.craftsman.catalogsvc.config;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URI;

@ConfigurationProperties(prefix = "client")
public record CatalogSvcClientProperties(
        @NotNull
        URI webservice
) {
}
