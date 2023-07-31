package com.craftsman.productsvcx.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductServiceNoContentException extends RuntimeException {

	private static final long serialVersionUID = -1932808270673621129L;

	public ProductServiceNoContentException() {
		super();
	}

	public ProductServiceNoContentException(String message, Throwable e) {
		super(message, e);
	}

}
