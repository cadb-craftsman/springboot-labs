package com.craftsman.productsvcx;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.craftsman.productsvcx.domain.model.service.ProductSvcBean;
import com.craftsman.productsvcx.services.IProductSvc;

@DisplayName("ProductSvcTest")
@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductSvcTest {

	@Autowired
	IProductSvc service;

	private static ProductSvcBean in;
	
	@BeforeAll
	static void initAll() {
		in = new ProductSvcBean(1L, "Product", "Product Description");
	}

	@Test
	@DisplayName("Test create operation")
	void testCreate() {
		ProductSvcBean bean = new ProductSvcBean(1L, "Product", "Product Description");
		service.create(in);
		assertTrue(in.equals(bean), "Insert a new record");
	}

	@Test
	@DisplayName("Test read operation")
	void testRead() {
		ProductSvcBean bean = service.read(in.getId());
		assertTrue(in.equals(bean), "Search a record");
	}

	@Test
	@DisplayName("Test update operation")
	void testUpdate() {
		ProductSvcBean bean = new ProductSvcBean(1L, "Product", "Product Description");
		service.update(in);
		assertTrue(in.equals(bean), "Update a record");
	}

	@Test
	@DisplayName("Test delete operation")
	void testDelete() {
		ProductSvcBean bean = new ProductSvcBean(1L, "Product", "Product Description");
		service.delete(in);
		assertTrue(in.equals(bean), "Delete a record");
	}

}
