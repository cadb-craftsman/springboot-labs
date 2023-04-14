package com.craftsman.catalogsvc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.craftsman.catalogsvc.domain.model.CatalogServiceEntity;


public interface CatalogServiceRepository {
	
	@Select("SELECT id, name, description FROM PRODUCT WHERE id = #{id}")
	public CatalogServiceEntity findById(Long id);
	
	@Select("SELECT  id, name, description FROM PRODUCT")
	public List<CatalogServiceEntity> findAll();
	
	@Insert("INSERT INTO PRODUCT (id, name, description) VALUES(#{id}, #{name}, #{description})")
	public int save(CatalogServiceEntity in);
	
	@Update("UPDATE PRODUCT SET name = #{name}, description = #{description} WHERE ID = #{id}")
	public int update(CatalogServiceEntity in);
	
	@Delete("DELETE FROM PRODUCT WHERE ID = #{id}")
	public int delete(Long id);
}
