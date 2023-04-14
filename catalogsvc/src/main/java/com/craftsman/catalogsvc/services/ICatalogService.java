package com.craftsman.catalogsvc.services;

import java.util.List;

import com.craftsman.catalogsvc.domain.exceptions.CatalogServiceException;
import com.craftsman.catalogsvc.domain.model.CatalogServiceBean;

public interface ICatalogService {

	CatalogServiceBean create(CatalogServiceBean in) throws CatalogServiceException;

	List<CatalogServiceBean> read() throws CatalogServiceException;
	
	CatalogServiceBean read(Long id) throws CatalogServiceException;

	CatalogServiceBean update(CatalogServiceBean in) throws CatalogServiceException;

	CatalogServiceBean delete(CatalogServiceBean in) throws CatalogServiceException;

}
