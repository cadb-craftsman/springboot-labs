package com.craftsman.catalogsvc.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.craftsman.catalogsvc.domain.exceptions.CatalogServiceException;
import com.craftsman.catalogsvc.domain.mappers.CatalogServiceFactoryMapper;
import com.craftsman.catalogsvc.domain.model.CatalogServiceBean;
import com.craftsman.catalogsvc.domain.model.CatalogServiceEntity;
import com.craftsman.catalogsvc.repository.CatalogServiceRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CatalogServiceImpl implements ICatalogService {

	@Autowired
	private CatalogServiceRepository repository;

	@Autowired(required = true)
	private CatalogServiceFactoryMapper mapper;

	@Override
	public CatalogServiceBean create(CatalogServiceBean in) throws CatalogServiceException {
		try {
			repository.save(mapper.mapToCatalogServiceEntity(in));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in method create");
			throw new CatalogServiceException("Exception in method read", e);
		}

		return in;
	}

	@Override
	public List<CatalogServiceBean> read() throws CatalogServiceException {
		List<CatalogServiceBean> list = null;
		try {
			Iterable<CatalogServiceEntity> itEntities = repository.findAll();
			if (itEntities != null) {
				list = new ArrayList<>();
				for (Iterator<CatalogServiceEntity> iterator = itEntities.iterator(); iterator.hasNext();) {
					CatalogServiceEntity e = (CatalogServiceEntity) iterator.next();
					list.add(mapper.mapToCatalogServiceBean(e));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in method read", e);
			throw new CatalogServiceException("Exception in method read", e);
		}
		return list;
	}

	@Override
	public CatalogServiceBean read(Long id) throws CatalogServiceException {

		try {
			return mapper.mapToCatalogServiceBean(repository.findById(id));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in method read", e);
			throw new CatalogServiceException("Exception in method read", e);
		}
	}

	@Override
	public CatalogServiceBean update(CatalogServiceBean in) throws CatalogServiceException {
		try {
			repository.update(mapper.mapToCatalogServiceEntity(in));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in method update");
			throw new CatalogServiceException("Exception in method update", e);
		}

		return in;
	}

	@Override
	public CatalogServiceBean delete(CatalogServiceBean in) throws CatalogServiceException {
		try {
			repository.delete(in.getId());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in method delete");
			throw new CatalogServiceException("Exception in method delete", e);
		}

		return in;
	}

}
