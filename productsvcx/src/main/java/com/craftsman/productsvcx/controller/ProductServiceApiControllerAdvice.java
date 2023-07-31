package com.craftsman.productsvcx.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.craftsman.productsvcx.domain.exceptions.MessageException;
import com.craftsman.productsvcx.domain.exceptions.ProductServiceException;
import com.craftsman.productsvcx.domain.exceptions.ProductServiceNoContentException;
import com.craftsman.productsvcx.domain.exceptions.ProductServiceNotFoundException;

@RestControllerAdvice
public class ProductServiceApiControllerAdvice {

	@ExceptionHandler(ProductServiceException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public MessageException handleInternalServerError(ProductServiceException e) {
		return new MessageException(e.getMessage(), e.getCause().toString());
	}
	
	@ExceptionHandler(ProductServiceNoContentException.class)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public MessageException handleNoContent(ProductServiceNoContentException e) {
		return new MessageException(e.getMessage(), e.getCause().toString());
	}
	
	@ExceptionHandler(ProductServiceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleNotFound(ProductServiceNotFoundException e) {
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
	
	@ExceptionHandler(BindException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Map<String, String> handleValidationException(BindException e) {
		Map<String, String> errors = new HashMap<>();

		e.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		return errors;
	}

}
