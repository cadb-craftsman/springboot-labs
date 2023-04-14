package com.craftsman.catalogsvc.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CatalogServiceResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1932808270673621129L;

	public CatalogServiceResourceNotFoundException() {
		super();
	}

	public CatalogServiceResourceNotFoundException(String message, Throwable e) {
		super(message, e);
	}

}
