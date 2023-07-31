package com.craftsman.productsvcx.domain.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.craftsman.productsvcx.domain.model.dto.ProductServiceDto;
import com.craftsman.productsvcx.domain.model.persistence.ProductServiceEntity;
import com.craftsman.productsvcx.domain.model.service.ProductServiceBean;

@Mapper
public interface ProductServiceFactoryMapper {
	
    @Mappings({
        @Mapping(target="id", source="id"),
        @Mapping(target="name", source="name"),
        @Mapping(target="description", source="description")
    })
	ProductServiceEntity mapToProductServiceEntity(ProductServiceBean in);
    
	ProductServiceBean mapToProductServiceBean(ProductServiceEntity in);
	
    @Mappings({
        @Mapping(target="id", source="id"),
        @Mapping(target="name", source="name"),
        @Mapping(target="description", source="description")
    })
	ProductServiceDto mapToProductServiceDto(ProductServiceBean in);
    
    ProductServiceBean mapToProductServiceBean(ProductServiceDto  in);
    
    List<ProductServiceDto> mapToListProductServiceDto(List<ProductServiceBean> in);

}
