package com.craftsman.catalogsvc.config;

import java.util.ArrayList;
import java.util.function.Consumer;

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
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.TypeHint;

import com.craftsman.catalogsvc.domain.model.CatalogServiceEntity;
import com.craftsman.catalogsvc.repository.CatalogServiceRepository;

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
                .registerType(CatalogServiceRepository.class, memberCategoryBuilder)
                .registerType(Logger.class, memberCategoryBuilder)
                .registerType(LogFactory.class, memberCategoryBuilder)
                .registerType(XMLLanguageDriver.class, memberCategoryBuilder)
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
                .registerType(CatalogServiceEntity.class, memberCategoryBuilder)
                .registerType(ArrayList.class, memberCategoryBuilder)
                .registerType(org.apache.ibatis.logging.jdk14.Jdk14LoggingImpl.class, memberCategoryBuilder);
        hints
                .proxies()
                .registerJdkProxy(CatalogServiceRepository.class);
    }
}
