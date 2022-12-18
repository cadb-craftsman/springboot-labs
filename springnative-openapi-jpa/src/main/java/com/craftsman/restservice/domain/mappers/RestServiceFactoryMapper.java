package com.craftsman.restservice.domain.mappers;

import org.mapstruct.Mapper;

import com.craftsman.restservice.domain.dto.RestServiceDto;
import com.craftsman.restservice.domain.model.RestServiceEntity;

@Mapper
public interface RestServiceFactoryMapper {
	
	RestServiceEntity mapToRestServiceEntity(RestServiceDto d);
	
	RestServiceDto mapToRestServiceDto(RestServiceEntity e);

}
