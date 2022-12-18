package com.craftsman.restservice.services;

import com.craftsman.restservice.domain.dto.RestServiceDto;
import com.craftsman.restservice.domain.dto.RestServiceDtoList;
import com.craftsman.restservice.domain.exceptions.RestServiceException;

public interface IRestService {

	public RestServiceDto create(RestServiceDto in) throws RestServiceException;

	public RestServiceDtoList read() throws RestServiceException;
	
	public RestServiceDto read(Long id) throws RestServiceException;

	public RestServiceDto update(RestServiceDto in) throws RestServiceException;

	public RestServiceDto delete(RestServiceDto in) throws RestServiceException;

}
