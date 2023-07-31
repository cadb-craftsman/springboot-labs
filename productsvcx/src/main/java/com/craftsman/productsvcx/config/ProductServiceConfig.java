package com.craftsman.productsvcx.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.craftsman.productsvcx.domain.mappers.ProductServiceFactoryMapperImpl;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class ProductServiceConfig {

	@Bean
	public GroupedOpenApi customOpenAPI(@Value("${springdoc.api-docs.version}") String appVersion,
			@Value("${app.openapi.path}") String pathsList, @Value("${app.openapi.package}") String packagesMatch,
			@Value("${app.openapi.group}") String group, @Value("${app.openapi.title}") String title,
			@Value("${app.openapi.description}") String description,
			@Value("${app.openapi.license.name}") String licenseName,
			@Value("${app.openapi.license.url}") String licenseUrl,
			@Value("${app.openapi.contact.name}") String contactName,
			@Value("${app.openapi.contact.url}") String contactUrl) {

		// String[] paths = { pathsList };
		String[] packagedToMatch = { packagesMatch };
		return GroupedOpenApi.builder().group(group)
				.addOpenApiCustomizer(openApi -> openApi.info(new Info().title(title).version(appVersion)
						.description(description).license(new License().name(licenseName).url(licenseUrl))
						.contact(new Contact().name(contactName).url(contactUrl))))
				// .pathsToMatch(paths)
				.packagesToScan(packagedToMatch).build();
	}

	@Bean
	public ProductServiceFactoryMapperImpl getFactoryMapper() {
		return new ProductServiceFactoryMapperImpl();
	}
}
