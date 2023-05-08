package com.craftsman.catalogsvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.craftsman.catalogsvc.domain.mappers.CatalogSvcFactoryMapper;
import com.craftsman.catalogsvc.domain.model.dto.CatalogSvcDto;
import com.craftsman.catalogsvc.domain.model.dto.CatalogSvcDtoList;
import com.craftsman.catalogsvc.services.ICatalogSvc;

@RestController
public class CatalogSvcApiController implements CatalogSvcApi {

	@Autowired
	private ICatalogSvc service;

	@Autowired(required = true)
	private CatalogSvcFactoryMapper mapper;

	@Override
	public ResponseEntity<CatalogSvcDto> putOperation(CatalogSvcDto in) {
		return ResponseEntity.ok(mapper.mapToCatalogSvcDto(service.update(mapper.mapToCatalogSvcBean(in))));
	}

	@Override
	public ResponseEntity<CatalogSvcDto> postOperation(CatalogSvcDto in) {
		return ResponseEntity.ok(mapper.mapToCatalogSvcDto(service.create(mapper.mapToCatalogSvcBean(in))));
	}

	@Override
	public ResponseEntity<CatalogSvcDto> deleteOperation(CatalogSvcDto in) {
		return ResponseEntity.ok(mapper.mapToCatalogSvcDto(service.delete(mapper.mapToCatalogSvcBean(in))));
	}

	@Override
	public ResponseEntity<CatalogSvcDto> getOperation(Long id) {
		return ResponseEntity.ok(mapper.mapToCatalogSvcDto(service.read(id)));
	}

	@Override
	public ResponseEntity<CatalogSvcDtoList> getOperation() {
		return ResponseEntity.ok(new CatalogSvcDtoList(mapper.mapToListCatalogSvcDto(service.read())));
	}


}
