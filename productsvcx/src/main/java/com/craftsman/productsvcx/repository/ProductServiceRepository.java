package com.craftsman.productsvcx.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.craftsman.productsvcx.domain.model.persistence.ProductServiceEntity;

@Mapper
public interface ProductServiceRepository {
	
	public ProductServiceEntity findById(Long id);
	
	public List<ProductServiceEntity> findAll();
	
	public int save(ProductServiceEntity in);
	
	public int update(ProductServiceEntity in);
	
	public int delete(Long id);
}
