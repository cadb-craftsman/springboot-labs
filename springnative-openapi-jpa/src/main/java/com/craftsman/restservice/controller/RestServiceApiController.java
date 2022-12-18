package com.craftsman.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.craftsman.restservice.domain.dto.RestServiceDto;
import com.craftsman.restservice.domain.dto.RestServiceDtoList;
import com.craftsman.restservice.services.IRestService;

@RestController
public class RestServiceApiController implements RestServiceApi {

	@Autowired
	private IRestService service;

	@Override
	public ResponseEntity<RestServiceDto> putOperation(RestServiceDto in) {
		return ResponseEntity.ok(service.update(in));
	}

	@Override
	public ResponseEntity<RestServiceDto> postOperation(RestServiceDto in) {
		return ResponseEntity.ok(service.create(in));
	}

	@Override
	public ResponseEntity<RestServiceDto> deleteOperation(RestServiceDto in) {
		return ResponseEntity.ok(service.delete(in));
	}

	@Override
	public ResponseEntity<RestServiceDto> getOperation(Long id) {
		return ResponseEntity.ok(service.read(id));
	}

	@Override
	public ResponseEntity<RestServiceDtoList> getOperation() {
		return ResponseEntity.ok(service.read());
	}

}
