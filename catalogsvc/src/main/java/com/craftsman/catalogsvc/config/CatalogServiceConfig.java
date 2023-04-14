package com.craftsman.catalogsvc.config;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.type.TypeAliasRegistry;
import org.mybatis.spring.SqlSessionTemplate;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.craftsman.catalogsvc.domain.mappers.CatalogServiceFactoryMapperImpl;
import com.craftsman.catalogsvc.domain.model.DatabaseProperties;
import com.craftsman.catalogsvc.domain.model.CatalogServiceEntity;
import com.craftsman.catalogsvc.repository.CatalogServiceRepository;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class CatalogServiceConfig {

	@Autowired
	private DatabaseProperties properties;

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
	public CatalogServiceFactoryMapperImpl getFactoryMapper() {
		return new CatalogServiceFactoryMapperImpl();
	}

	@Bean
	public SqlSessionFactory getSqlSessionFactory() throws Exception {
		DataSource datasource = DataSourceBuilder.create().username(properties.getUsername())
				.password(properties.getPassword()).url(properties.getUrl())
				.driverClassName(properties.getDriverClassName()).build();
		TransactionFactory trxFactory = new JdbcTransactionFactory();

		Environment env = new Environment("connection", trxFactory, datasource);
		org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration(env);

		TypeAliasRegistry aliases = config.getTypeAliasRegistry();
		aliases.registerAlias("record", CatalogServiceEntity.class);

		config.addMapper(CatalogServiceRepository.class);

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(config);
		return factory;

	}

	@Bean
	public SqlSessionTemplate getSqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(getSqlSessionFactory(), ExecutorType.SIMPLE);
	}

	@Bean
	public CatalogServiceRepository getCatalogServiceRepository() throws Exception {
		return getSqlSessionTemplate().getMapper(CatalogServiceRepository.class);
	}

}
