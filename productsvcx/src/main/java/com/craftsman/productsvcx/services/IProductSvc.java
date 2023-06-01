package com.craftsman.productsvcx.services;

import java.util.List;

import com.craftsman.productsvcx.domain.exceptions.ProductSvcException;
import com.craftsman.productsvcx.domain.model.service.ProductSvcBean;

public interface IProductSvc {

	ProductSvcBean create(ProductSvcBean in) throws ProductSvcException;

	List<ProductSvcBean> read() throws ProductSvcException;
	
	ProductSvcBean read(Long id) throws ProductSvcException;

	ProductSvcBean update(ProductSvcBean in) throws ProductSvcException;

	ProductSvcBean delete(ProductSvcBean in) throws ProductSvcException;

}
