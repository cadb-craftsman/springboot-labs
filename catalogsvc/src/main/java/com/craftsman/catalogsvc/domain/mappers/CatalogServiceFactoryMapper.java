package com.craftsman.catalogsvc.domain.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.craftsman.catalogsvc.domain.dto.CatalogServiceDto;
import com.craftsman.catalogsvc.domain.model.CatalogServiceBean;
import com.craftsman.catalogsvc.domain.model.CatalogServiceEntity;

@Mapper
public interface CatalogServiceFactoryMapper {
	
    @Mappings({
        @Mapping(target="id", source="id"),
        @Mapping(target="name", source="name"),
        @Mapping(target="description", source="description")
    })
	CatalogServiceEntity mapToCatalogServiceEntity(CatalogServiceBean in);
    
	CatalogServiceBean mapToCatalogServiceBean(CatalogServiceEntity in);
	
    @Mappings({
        @Mapping(target="id", source="id"),
        @Mapping(target="name", source="name"),
        @Mapping(target="description", source="description")
    })
	CatalogServiceDto mapToCatalogServiceDto(CatalogServiceBean in);
    
    CatalogServiceBean mapToCatalogServiceBean(CatalogServiceDto  in);
    
    List<CatalogServiceDto> mapToListCatalogServiceDto(List<CatalogServiceBean> in);

}
