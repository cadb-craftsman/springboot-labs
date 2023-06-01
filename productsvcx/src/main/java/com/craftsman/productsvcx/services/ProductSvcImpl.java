package com.craftsman.productsvcx.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.craftsman.productsvcx.domain.exceptions.ProductSvcException;
import com.craftsman.productsvcx.domain.mappers.ProductSvcFactoryMapper;
import com.craftsman.productsvcx.domain.model.persistence.ProductSvcEntity;
import com.craftsman.productsvcx.domain.model.service.ProductSvcBean;
import com.craftsman.productsvcx.repository.ProductSvcRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class ProductSvcImpl implements IProductSvc {

	private ProductSvcRepository repository;

	private ProductSvcFactoryMapper mapper;

	@Override
	public ProductSvcBean create(ProductSvcBean in) throws ProductSvcException {
		try {
			repository.save(mapper.mapToProductSvcEntity(in));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in method create");
			throw new ProductSvcException("Exception in method read", e);
		}

		return in;
	}

	@Override
	public List<ProductSvcBean> read() throws ProductSvcException {
		List<ProductSvcBean> list = null;
		try {
			Iterable<ProductSvcEntity> itEntities = repository.findAll();
			if (itEntities != null) {
				list = new ArrayList<>();
				for (Iterator<ProductSvcEntity> iterator = itEntities.iterator(); iterator.hasNext();) {
					ProductSvcEntity e = (ProductSvcEntity) iterator.next();
					list.add(mapper.mapToProductSvcBean(e));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in method read", e);
			throw new ProductSvcException("Exception in method read", e);
		}
		return list;
	}

	@Override
	public ProductSvcBean read(Long id) throws ProductSvcException {

		try {
			return mapper.mapToProductSvcBean(repository.findById(id));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in method read", e);
			throw new ProductSvcException("Exception in method read", e);
		}
	}

	@Override
	public ProductSvcBean update(ProductSvcBean in) throws ProductSvcException {
		try {
			repository.update(mapper.mapToProductSvcEntity(in));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in method update");
			throw new ProductSvcException("Exception in method update", e);
		}

		return in;
	}

	@Override
	public ProductSvcBean delete(ProductSvcBean in) throws ProductSvcException {
		try {
			repository.delete(in.getId());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in method delete");
			throw new ProductSvcException("Exception in method delete", e);
		}

		return in;
	}

}
