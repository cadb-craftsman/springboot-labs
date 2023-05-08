package com.craftsman.catalogsvc.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.function.Consumer;

import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.javassist.util.proxy.ProxyFactory;
import org.apache.ibatis.javassist.util.proxy.RuntimeSupport;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.logging.log4j.Log4jImpl;
import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.apache.ibatis.logging.nologging.NoLoggingImpl;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.scripting.defaults.RawLanguageDriver;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.TypeHint;
import org.springframework.core.io.ClassPathResource;

import com.craftsman.catalogsvc.domain.model.persistence.CatalogSvcEntity;
import com.craftsman.catalogsvc.repository.CatalogSvcRepository;
import com.zaxxer.hikari.HikariDataSource;

public class MyBatisHintsRegistrar implements RuntimeHintsRegistrar {
    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        Consumer<TypeHint.Builder> memberCategoryBuilder = builder -> builder.withMembers(
                MemberCategory.INVOKE_PUBLIC_METHODS,
                MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS,
                MemberCategory.PUBLIC_CLASSES,
                MemberCategory.PUBLIC_FIELDS,
                MemberCategory.DECLARED_CLASSES,
                MemberCategory.DECLARED_FIELDS,
                MemberCategory.INTROSPECT_DECLARED_METHODS,
                MemberCategory.INTROSPECT_DECLARED_CONSTRUCTORS
                );
        hints
                .reflection()
                .registerType(CatalogSvcRepository.class, memberCategoryBuilder)
                .registerType(CatalogSvcEntity.class, memberCategoryBuilder)
                .registerType(Logger.class, memberCategoryBuilder)
                .registerType(LogFactory.class, memberCategoryBuilder)
                .registerType(LoggerFactory.class, memberCategoryBuilder)
                .registerType(XMLLanguageDriver.class, memberCategoryBuilder)
                .registerType(XMLMapperBuilder.class, memberCategoryBuilder)
                .registerType(RuntimeSupport.class, memberCategoryBuilder)
                .registerType(ProxyFactory.class, memberCategoryBuilder)
                .registerType(Log.class, memberCategoryBuilder)
                .registerType(StdOutImpl.class, memberCategoryBuilder)
                .registerType(NoLoggingImpl.class, memberCategoryBuilder)
                .registerType(SqlSessionTemplate.class, memberCategoryBuilder)
                .registerType(SqlSessionFactory.class, memberCategoryBuilder)
                .registerType(SqlSessionFactoryBean.class, memberCategoryBuilder)
                .registerType(Log4jImpl.class, memberCategoryBuilder)
                .registerType(Log4j2Impl.class, memberCategoryBuilder)
                .registerType(RawLanguageDriver.class, memberCategoryBuilder)
                .registerType(HikariDataSource.class, memberCategoryBuilder)
                .registerType(ArrayList.class, memberCategoryBuilder)
                .registerType(HashMap.class, memberCategoryBuilder)
                .registerType(TreeSet.class, memberCategoryBuilder)
                .registerType(HashSet.class, memberCategoryBuilder)
                .registerType(org.apache.ibatis.logging.jdk14.Jdk14LoggingImpl.class, memberCategoryBuilder);
        hints
                .proxies()
                .registerJdkProxy(CatalogSvcRepository.class);  

        hints.resources().registerResource(new ClassPathResource("org/apache/ibatis/builder/xml/mybatis-3-config.dtd"));
        hints.resources().registerResource(new ClassPathResource("org/apache/ibatis/builder/xml/mybatis-3-mapper.dtd"));
        hints.resources().registerResource(new ClassPathResource("CatalogSvcRepository.xml", CatalogSvcRepository.class));
        
    }
}
