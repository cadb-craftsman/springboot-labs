package com.craftsman.productsvc.services;

import java.util.List;

import com.craftsman.productsvc.domain.exceptions.ProductSvcException;
import com.craftsman.productsvc.domain.model.service.ProductSvcBean;

public interface IProductSvc {

	ProductSvcBean create(ProductSvcBean in) throws ProductSvcException;

	List<ProductSvcBean> read() throws ProductSvcException;
	
	ProductSvcBean read(Long id) throws ProductSvcException;

	ProductSvcBean update(ProductSvcBean in) throws ProductSvcException;

	ProductSvcBean delete(ProductSvcBean in) throws ProductSvcException;

}
