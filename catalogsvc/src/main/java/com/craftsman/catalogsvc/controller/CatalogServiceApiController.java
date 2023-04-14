package com.craftsman.catalogsvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.craftsman.catalogsvc.domain.dto.CatalogServiceDto;
import com.craftsman.catalogsvc.domain.dto.CatalogServiceDtoList;
import com.craftsman.catalogsvc.domain.mappers.CatalogServiceFactoryMapper;
import com.craftsman.catalogsvc.services.ICatalogService;

@RestController
public class CatalogServiceApiController implements CatalogServiceApi {

	@Autowired
	private ICatalogService service;

	@Autowired(required = true)
	private CatalogServiceFactoryMapper mapper;

	@Override
	public ResponseEntity<CatalogServiceDto> putOperation(CatalogServiceDto in) {
		return ResponseEntity.ok(mapper.mapToCatalogServiceDto(service.update(mapper.mapToCatalogServiceBean(in))));
	}

	@Override
	public ResponseEntity<CatalogServiceDto> postOperation(CatalogServiceDto in) {
		return ResponseEntity.ok(mapper.mapToCatalogServiceDto(service.create(mapper.mapToCatalogServiceBean(in))));
	}

	@Override
	public ResponseEntity<CatalogServiceDto> deleteOperation(CatalogServiceDto in) {
		return ResponseEntity.ok(mapper.mapToCatalogServiceDto(service.delete(mapper.mapToCatalogServiceBean(in))));
	}

	@Override
	public ResponseEntity<CatalogServiceDto> getOperation(Long id) {
		return ResponseEntity.ok(mapper.mapToCatalogServiceDto(service.read(id)));
	}

	@Override
	public ResponseEntity<CatalogServiceDtoList> getOperation() {
		return ResponseEntity.ok(new CatalogServiceDtoList(mapper.mapToListCatalogServiceDto(service.read())));
	}

}
