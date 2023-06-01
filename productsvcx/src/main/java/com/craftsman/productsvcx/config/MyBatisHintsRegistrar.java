package com.craftsman.productsvcx.config;

import com.craftsman.productsvcx.repository.ProductSvcRepository;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.core.io.ClassPathResource;

public class MyBatisHintsRegistrar implements RuntimeHintsRegistrar {
    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        hints.resources().registerResource(new ClassPathResource("org/apache/ibatis/builder/xml/mybatis-3-config.dtd"));
        hints.resources().registerResource(new ClassPathResource("org/apache/ibatis/builder/xml/mybatis-3-mapper.dtd"));
        hints.resources().registerResource(new ClassPathResource("ProductSvcRepository.xml", ProductSvcRepository.class));
        
    }
}
