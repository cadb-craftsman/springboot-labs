package com.craftsman.catalogsvc.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.craftsman.catalogsvc.domain.exceptions.CatalogSvcException;
import com.craftsman.catalogsvc.domain.mappers.CatalogSvcFactoryMapper;
import com.craftsman.catalogsvc.domain.model.persistence.CatalogSvcEntity;
import com.craftsman.catalogsvc.domain.model.service.CatalogSvcBean;
import com.craftsman.catalogsvc.repository.CatalogSvcRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CatalogSvcImpl implements ICatalogSvc {

	@Autowired
	private CatalogSvcRepository repository;

	@Autowired
	private CatalogSvcFactoryMapper mapper;

	@Override
	public CatalogSvcBean create(CatalogSvcBean in) throws CatalogSvcException {
		try {
			repository.save(mapper.mapToCatalogSvcEntity(in));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in method create");
			throw new CatalogSvcException("Exception in method create", e);
		}

		return in;
	}

	@Override
	public List<CatalogSvcBean> read() throws CatalogSvcException {
		List<CatalogSvcBean> list = null;
		try {
			Iterable<CatalogSvcEntity> itEntities = repository.findAll();
			if (itEntities != null) {
				list = new ArrayList<>();
				for (Iterator<CatalogSvcEntity> iterator = itEntities.iterator(); iterator.hasNext();) {
					CatalogSvcEntity e = (CatalogSvcEntity) iterator.next();
					list.add(mapper.mapToCatalogSvcBean(e));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in method read", e);
			throw new CatalogSvcException("Exception in method read", e);
		}
		return list;
	}

	@Override
	public CatalogSvcBean read(Long id) throws CatalogSvcException {

		try {
			return mapper.mapToCatalogSvcBean(repository.findById(id));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in method read", e);
			throw new CatalogSvcException("Exception in method read", e);
		}
	}

	@Override
	public CatalogSvcBean update(CatalogSvcBean in) throws CatalogSvcException {
		try {
			repository.update(mapper.mapToCatalogSvcEntity(in));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in method update");
			throw new CatalogSvcException("Exception in method update", e);
		}

		return in;
	}

	@Override
	public CatalogSvcBean delete(CatalogSvcBean in) throws CatalogSvcException {
		try {
			repository.delete(in.getId());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in method delete");
			throw new CatalogSvcException("Exception in method delete", e);
		}

		return in;
	}
}
