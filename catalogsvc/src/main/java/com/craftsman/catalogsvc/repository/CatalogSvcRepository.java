package com.craftsman.catalogsvc.repository;

import java.util.List;

import com.craftsman.catalogsvc.domain.model.persistence.CatalogSvcEntity;

public interface CatalogSvcRepository {
	
	public CatalogSvcEntity findById(Long id);
	
	public List<CatalogSvcEntity> findAll();
	
	public int save(CatalogSvcEntity in);
	
	public int update(CatalogSvcEntity in);
	
	public int delete(Long id);
}
