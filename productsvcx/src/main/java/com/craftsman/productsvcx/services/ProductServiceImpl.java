package com.craftsman.productsvcx.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.craftsman.productsvcx.domain.exceptions.ProductServiceException;
import com.craftsman.productsvcx.domain.mappers.ProductServiceFactoryMapper;
import com.craftsman.productsvcx.domain.model.persistence.ProductServiceEntity;
import com.craftsman.productsvcx.domain.model.service.ProductServiceBean;
import com.craftsman.productsvcx.repository.ProductServiceRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

	private ProductServiceRepository repository;

	private ProductServiceFactoryMapper mapper;

	@Override
	public ProductServiceBean create(ProductServiceBean in) throws ProductServiceException {
		try {
			repository.save(mapper.mapToProductServiceEntity(in));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in method create");
			throw new ProductServiceException("Exception in method read", e);
		}

		return in;
	}

	@Override
	public List<ProductServiceBean> read() throws ProductServiceException {
		List<ProductServiceBean> list = null;
		try {
			Iterable<ProductServiceEntity> itEntities = repository.findAll();
			if (itEntities != null) {
				list = new ArrayList<>();
				for (Iterator<ProductServiceEntity> iterator = itEntities.iterator(); iterator.hasNext();) {
					ProductServiceEntity e = (ProductServiceEntity) iterator.next();
					list.add(mapper.mapToProductServiceBean(e));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in method read", e);
			throw new ProductServiceException("Exception in method read", e);
		}
		return list;
	}

	@Override
	public ProductServiceBean read(Long id) throws ProductServiceException {

		try {
			return mapper.mapToProductServiceBean(repository.findById(id));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in method read", e);
			throw new ProductServiceException("Exception in method read", e);
		}
	}

	@Override
	public ProductServiceBean update(ProductServiceBean in) throws ProductServiceException {
		try {
			repository.update(mapper.mapToProductServiceEntity(in));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in method update");
			throw new ProductServiceException("Exception in method update", e);
		}

		return in;
	}

	@Override
	public ProductServiceBean delete(ProductServiceBean in) throws ProductServiceException {
		try {
			repository.delete(in.getId());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in method delete");
			throw new ProductServiceException("Exception in method delete", e);
		}

		return in;
	}

}
