package com.craftsman.productsvcx.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.craftsman.productsvcx.domain.exceptions.ProductSvcException;
import com.craftsman.productsvcx.domain.exceptions.ProductSvcResourceNotFoundException;

@RestControllerAdvice
public class ProductSvcApiControllerAdvice {

	@ExceptionHandler(ProductSvcException.class)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public String handleProductoNotFound(ProductSvcException e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(ProductSvcResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleProductoNotFound(ProductSvcResourceNotFoundException e) {
		return e.getMessage();
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException e) {
		Map<String, String> errors = new HashMap<>();

		e.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		return errors;
	}

}
