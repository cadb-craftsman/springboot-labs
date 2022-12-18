package com.craftsman.restservice.domain.exceptions;

public class RestServiceResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1932808270673621129L;

	public RestServiceResourceNotFoundException() {
		super();
	}

	public RestServiceResourceNotFoundException(String message, Throwable e) {
		super(message, e);
	}

}
