package com.craftsman.productsvcx.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.craftsman.productsvcx.domain.mappers.ProductSvcFactoryMapper;
import com.craftsman.productsvcx.domain.model.dto.ProductSvcDto;
import com.craftsman.productsvcx.domain.model.dto.ProductSvcDtoList;
import com.craftsman.productsvcx.services.IProductSvc;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ProductSvcApiController implements ProductSvcApi {

	private IProductSvc service;

	private ProductSvcFactoryMapper mapper;

	@Override
	public ResponseEntity<ProductSvcDto> putOperation(ProductSvcDto in) {
		return ResponseEntity.ok(mapper.mapToProductSvcDto(service.update(mapper.mapToProductSvcBean(in))));
	}

	@Override
	public ResponseEntity<ProductSvcDto> postOperation(ProductSvcDto in) {
		return ResponseEntity.ok(mapper.mapToProductSvcDto(service.create(mapper.mapToProductSvcBean(in))));
	}

	@Override
	public ResponseEntity<ProductSvcDto> deleteOperation(ProductSvcDto in) {
		return ResponseEntity.ok(mapper.mapToProductSvcDto(service.delete(mapper.mapToProductSvcBean(in))));
	}

	@Override
	public ResponseEntity<ProductSvcDto> getOperation(Long id) {
		return ResponseEntity.ok(mapper.mapToProductSvcDto(service.read(id)));
	}

	@Override
	public ResponseEntity<ProductSvcDtoList> getOperation() {
		return ResponseEntity.ok(new ProductSvcDtoList(mapper.mapToListProductSvcDto(service.read())));
	}

}
