package com.craftsman.productsvc.repository;

import com.craftsman.productsvc.domain.model.persistence.ProductSvcEntity;

import java.util.List;

public interface ProductSvcRepository {
	
	public ProductSvcEntity findById(Long id);
	
	public List<ProductSvcEntity> findAll();
	
	public int save(ProductSvcEntity in);
	
	public int update(ProductSvcEntity in);
	
	public int delete(Long id);
}
