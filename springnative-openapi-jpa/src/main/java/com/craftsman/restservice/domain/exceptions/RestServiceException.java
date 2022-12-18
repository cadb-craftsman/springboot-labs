package com.craftsman.restservice.domain.exceptions;

public class RestServiceException extends RuntimeException {

	private static final long serialVersionUID = -1932808270673621129L;

	public RestServiceException() {
		super();
	}

	public RestServiceException(String message, Throwable e) {
		super(message, e);
	}

}
