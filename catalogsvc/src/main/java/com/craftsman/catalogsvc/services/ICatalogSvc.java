package com.craftsman.catalogsvc.services;

import java.util.List;

import com.craftsman.catalogsvc.domain.exceptions.CatalogSvcException;
import com.craftsman.catalogsvc.domain.model.service.CatalogSvcBean;

public interface ICatalogSvc {

	CatalogSvcBean create(CatalogSvcBean in) throws CatalogSvcException;

	List<CatalogSvcBean> read() throws CatalogSvcException;
	
	CatalogSvcBean read(Long id) throws CatalogSvcException;

	CatalogSvcBean update(CatalogSvcBean in) throws CatalogSvcException;

	CatalogSvcBean delete(CatalogSvcBean in) throws CatalogSvcException;

}
