package com.craftsman.productsvcx.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.craftsman.productsvcx.domain.model.persistence.ProductSvcEntity;

@Mapper
public interface ProductSvcRepository {
	
	//@Select("SELECT id, name, description FROM PRODUCT WHERE id = #{id}")
	public ProductSvcEntity findById(Long id);
	
	//@Select("SELECT  id, name, description FROM PRODUCT")
	public List<ProductSvcEntity> findAll();
	
	//@Insert("INSERT INTO PRODUCT (id, name, description) VALUES(#{id}, #{name}, #{description})")
	public int save(ProductSvcEntity in);
	
	//@Update("UPDATE PRODUCT SET name = #{name}, description = #{description} WHERE ID = #{id}")
	public int update(ProductSvcEntity in);
	
	//@Delete("DELETE FROM PRODUCT WHERE ID = #{id}")
	public int delete(Long id);
}
