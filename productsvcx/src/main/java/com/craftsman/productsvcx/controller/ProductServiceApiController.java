package com.craftsman.productsvcx.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.craftsman.productsvcx.domain.mappers.ProductServiceFactoryMapper;
import com.craftsman.productsvcx.domain.model.dto.ProductServiceDto;
import com.craftsman.productsvcx.domain.model.dto.ProductServiceDtoList;
import com.craftsman.productsvcx.services.IProductService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ProductServiceApiController implements ProductServiceApi {

	private IProductService service;

	private ProductServiceFactoryMapper mapper;

	@Override
	public ResponseEntity<ProductServiceDto> putOperation(Long id, ProductServiceDto in) {
		return ResponseEntity.ok(mapper.mapToProductServiceDto(service.update(mapper.mapToProductServiceBean(in))));
	}

	@Override
	public ResponseEntity<ProductServiceDto> postOperation(ProductServiceDto in) {
		return ResponseEntity.ok(mapper.mapToProductServiceDto(service.create(mapper.mapToProductServiceBean(in))));
	}

	@Override
	public ResponseEntity<ProductServiceDto> deleteOperation(Long id) {
		return ResponseEntity.ok(mapper.mapToProductServiceDto(service.delete(mapper.mapToProductServiceBean(new ProductServiceDto(id, null, null)))));
	}

	@Override
	public ResponseEntity<ProductServiceDto> getOperation(Long id) {
		return ResponseEntity.ok(mapper.mapToProductServiceDto(service.read(id)));
	}

	@Override
	public ResponseEntity<ProductServiceDtoList> getOperation() {
		return ResponseEntity.ok(new ProductServiceDtoList(mapper.mapToListProductServiceDto(service.read())));
	}

}
