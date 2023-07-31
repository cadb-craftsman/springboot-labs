package com.craftsman.productsvcx.services;

import java.util.List;

import com.craftsman.productsvcx.domain.exceptions.ProductServiceException;
import com.craftsman.productsvcx.domain.model.service.ProductServiceBean;

public interface IProductService {

	ProductServiceBean create(ProductServiceBean in) throws ProductServiceException;

	List<ProductServiceBean> read() throws ProductServiceException;
	
	ProductServiceBean read(Long id) throws ProductServiceException;

	ProductServiceBean update(ProductServiceBean in) throws ProductServiceException;

	ProductServiceBean delete(ProductServiceBean in) throws ProductServiceException;

}
