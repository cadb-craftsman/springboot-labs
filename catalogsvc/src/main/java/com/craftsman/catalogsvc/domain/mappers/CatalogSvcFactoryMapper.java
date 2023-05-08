package com.craftsman.catalogsvc.domain.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.craftsman.catalogsvc.domain.model.dto.CatalogSvcDto;
import com.craftsman.catalogsvc.domain.model.persistence.CatalogSvcEntity;
import com.craftsman.catalogsvc.domain.model.service.CatalogSvcBean;

@Mapper
public interface CatalogSvcFactoryMapper {
	
    @Mappings({
        @Mapping(target="id", source="id"),
        @Mapping(target="name", source="name"),
        @Mapping(target="description", source="description")
    })
	CatalogSvcEntity mapToCatalogSvcEntity(CatalogSvcBean in);
    
	CatalogSvcBean mapToCatalogSvcBean(CatalogSvcEntity in);
	
    @Mappings({
        @Mapping(target="id", source="id"),
        @Mapping(target="name", source="name"),
        @Mapping(target="description", source="description")
    })
	CatalogSvcDto mapToCatalogSvcDto(CatalogSvcBean in);
    
    CatalogSvcBean mapToCatalogSvcBean(CatalogSvcDto  in);
    
    List<CatalogSvcDto> mapToListCatalogSvcDto(List<CatalogSvcBean> in);

}
