package com.craftsman.catalogsvc.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.craftsman.catalogsvc.domain.mappers.CatalogSvcFactoryMapperImpl;
import com.craftsman.catalogsvc.domain.model.persistence.DatabaseProperties;
import com.craftsman.catalogsvc.repository.CatalogSvcRepository;
import com.craftsman.catalogsvc.repository.handlers.StringTrimTypeHandler;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class CatalogSvcConfig {

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
	public CatalogSvcFactoryMapperImpl getFactoryMapper() {
		return new CatalogSvcFactoryMapperImpl();
	}

	@Bean
	public DataSource getDataSource() {
		DataSource datasource = DataSourceBuilder.create().username(properties.getUsername())
				.password(properties.getPassword()).url(properties.getUrl())
				.driverClassName(properties.getDriverClassName()).build();
		return datasource;
	}

	@Bean
	public SqlSessionFactory getSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(getDataSource());
		sqlSessionFactoryBean
				.setMapperLocations(new ClassPathResource("CatalogSvcRepository.xml", CatalogSvcRepository.class));
		sqlSessionFactoryBean.setTypeHandlers(new StringTrimTypeHandler());
		return sqlSessionFactoryBean.getObject();

	}

	@Bean
	public SqlSessionTemplate getSqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(getSqlSessionFactory(), ExecutorType.SIMPLE);
	}

	@Bean
	public CatalogSvcRepository getCatalogSvcRepository() throws Exception {
		return getSqlSessionTemplate().getMapper(CatalogSvcRepository.class);
	}

}
