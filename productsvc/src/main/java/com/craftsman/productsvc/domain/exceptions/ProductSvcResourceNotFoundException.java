package com.craftsman.productsvc.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductSvcResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1932808270673621129L;

	public ProductSvcResourceNotFoundException() {
		super();
	}

	public ProductSvcResourceNotFoundException(String message, Throwable e) {
		super(message, e);
	}

}
