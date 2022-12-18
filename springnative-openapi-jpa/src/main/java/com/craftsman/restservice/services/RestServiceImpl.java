package com.craftsman.restservice.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.craftsman.restservice.domain.dto.RestServiceDto;
import com.craftsman.restservice.domain.dto.RestServiceDtoList;
import com.craftsman.restservice.domain.exceptions.RestServiceException;
import com.craftsman.restservice.domain.mappers.RestServiceFactoryMapper;
import com.craftsman.restservice.domain.model.RestServiceEntity;
import com.craftsman.restservice.repository.RestServiceRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RestServiceImpl implements IRestService {

	@Autowired
	private RestServiceRepository repository;

	@Autowired(required = true)
	private RestServiceFactoryMapper mapper;

	@Override
	public RestServiceDto create(RestServiceDto in) throws RestServiceException {
		return createDelegate(in);
	}
	
	@Override
	public RestServiceDtoList read() throws RestServiceException {		
		return readDelegate();
	}

	@Override
	public RestServiceDto read(Long id) throws RestServiceException {
		return readDelegate(id);
	}

	@Override
	public RestServiceDto update(RestServiceDto in) throws RestServiceException {
		return updateDelegate(in);
	}

	@Override
	public RestServiceDto delete(RestServiceDto in) throws RestServiceException {
		return deleteDelegate(in);
	}

	private RestServiceDto createDelegate(RestServiceDto in) throws RestServiceException {
		try {
			repository.save(mapper.mapToRestServiceEntity(in));
		} catch (Exception e) {
			log.error("Exception in method read");
			throw new RestServiceException("Exception in method read", e);
		}

		return in;
	}

	private RestServiceDtoList readDelegate() throws RestServiceException {
		RestServiceDtoList restServiceList = new RestServiceDtoList();
		List<RestServiceDto> dtoList = null;
		try {
			Iterable<RestServiceEntity> itEntities = repository.findAll();
			if (itEntities != null) {
				dtoList = new ArrayList<>();
				for (Iterator<RestServiceEntity> iterator = itEntities.iterator(); iterator.hasNext();) {
					RestServiceEntity e = (RestServiceEntity) iterator.next();
					dtoList.add(mapper.mapToRestServiceDto(e));
				}
				restServiceList.setDtoList(dtoList);
			}
		} catch (Exception e) {
			log.error("Exception in method read", e);
			throw new RestServiceException("Exception in method read", e);
		}
		return restServiceList;
	}

	private RestServiceDto readDelegate(Long id) throws RestServiceException {
		RestServiceDto restServiceDto = null;
		try {
			Optional<RestServiceEntity> e = repository.findById(id);
			if (e != null) {
				restServiceDto = mapper.mapToRestServiceDto(e.get());
			}
		} catch (Exception e) {
			log.error("Exception in method read", e);
			throw new RestServiceException("Exception in method read", e);
		}
		return restServiceDto;
	}

	private RestServiceDto updateDelegate(RestServiceDto in) throws RestServiceException {
		try {
			repository.save(mapper.mapToRestServiceEntity(in));
		} catch (Exception e) {
			log.error("Exception in method read");
			throw new RestServiceException("Exception in method read", e);
		}

		return in;
	}

	private RestServiceDto deleteDelegate(RestServiceDto in) throws RestServiceException {
		try {
			repository.delete(mapper.mapToRestServiceEntity(in));
		} catch (Exception e) {
			log.error("Exception in method read");
			throw new RestServiceException("Exception in method read", e);
		}

		return in;
	}

}
