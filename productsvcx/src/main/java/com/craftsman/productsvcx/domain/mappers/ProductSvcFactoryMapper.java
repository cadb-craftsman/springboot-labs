package com.craftsman.productsvcx.domain.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.craftsman.productsvcx.domain.model.dto.ProductSvcDto;
import com.craftsman.productsvcx.domain.model.persistence.ProductSvcEntity;
import com.craftsman.productsvcx.domain.model.service.ProductSvcBean;

@Mapper
public interface ProductSvcFactoryMapper {
	
    @Mappings({
        @Mapping(target="id", source="id"),
        @Mapping(target="name", source="name"),
        @Mapping(target="description", source="description")
    })
	ProductSvcEntity mapToProductSvcEntity(ProductSvcBean in);
    
	ProductSvcBean mapToProductSvcBean(ProductSvcEntity in);
	
    @Mappings({
        @Mapping(target="id", source="id"),
        @Mapping(target="name", source="name"),
        @Mapping(target="description", source="description")
    })
	ProductSvcDto mapToProductSvcDto(ProductSvcBean in);
    
    ProductSvcBean mapToProductSvcBean(ProductSvcDto  in);
    
    List<ProductSvcDto> mapToListProductSvcDto(List<ProductSvcBean> in);

}
