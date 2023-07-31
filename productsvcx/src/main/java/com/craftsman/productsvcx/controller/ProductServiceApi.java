package com.craftsman.productsvcx.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.craftsman.productsvcx.domain.model.dto.ProductServiceDto;
import com.craftsman.productsvcx.domain.model.dto.ProductServiceDtoList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RequestMapping("/api/v1/services")
public interface ProductServiceApi {

	/**
	 * PUT REST Service
	 */
	@Operation(operationId = "updateRecord", summary = "Update a record", tags = { "ProductService" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "record created"),
			@ApiResponse(responseCode = "400", description = "invalid user operation"),
			@ApiResponse(responseCode = "404", description = "url not found") })
	@PutMapping(value = "{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(value = HttpStatus.CONFLICT)
	@ResponseBody
	public ResponseEntity<ProductServiceDto> putOperation(@PathVariable(value = "id") Long id, @Valid @RequestBody(required = true) ProductServiceDto in);

	/**
	 * POST REST Service
	 */
	@Operation(operationId = "createRecord", summary = "Create a record", tags = { "ProductService" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "record created"),
			@ApiResponse(responseCode = "400", description = "invalid user operation"),
			@ApiResponse(responseCode = "404", description = "url not found") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(value = HttpStatus.CREATED)
	@ResponseBody
	public ResponseEntity<ProductServiceDto> postOperation(@Valid @RequestBody() ProductServiceDto in);

	/**
	 * DELETE REST Service
	 */
	@Operation(operationId = "deleteRecord", summary = "Delete a record", tags = { "ProductService" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "record created"),
			@ApiResponse(responseCode = "400", description = "invalid user operation"),
			@ApiResponse(responseCode = "404", description = "url not found") })
	@DeleteMapping(value = "{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@ResponseBody
	public ResponseEntity<ProductServiceDto> deleteOperation(@PathVariable(value = "id") Long id);

	/**
	 * GET REST Service
	 */
	@Operation(operationId = "getAllRecords", summary = "Get all records", tags = { "ProductService" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "record created"),
			@ApiResponse(responseCode = "400", description = "invalid user operation"),
			@ApiResponse(responseCode = "404", description = "url not found") })
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ResponseEntity<ProductServiceDtoList> getOperation();

	/**
	 * GET REST Service
	 */
	@Operation(operationId = "getRecordById", summary = "Get a record by id", tags = { "ProductService" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "record created"),
			@ApiResponse(responseCode = "400", description = "invalid user operation"),
			@ApiResponse(responseCode = "404", description = "url not found") })
	@GetMapping(value = "{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ResponseEntity<ProductServiceDto> getOperation(@PathVariable(value = "id") Long id);

}
