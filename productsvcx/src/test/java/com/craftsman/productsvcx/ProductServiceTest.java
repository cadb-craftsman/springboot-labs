package com.craftsman.productsvcx;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.craftsman.productsvcx.domain.model.service.ProductServiceBean;
import com.craftsman.productsvcx.services.IProductService;

@DisplayName("ProductServiceTest")
@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceTest {

	@Autowired
	IProductService service;

	private static ProductServiceBean in;
	
	@BeforeAll
	static void initAll() {
		in = new ProductServiceBean(1L, "Product", "Product Description");
	}

	@Test
	@DisplayName("Test create operation")
	void testCreate() {
		ProductServiceBean bean = new ProductServiceBean(1L, "Product", "Product Description");
		service.create(in);
		assertTrue(in.equals(bean), "Insert a new record");
	}

	@Test
	@DisplayName("Test read operation")
	void testRead() {
		ProductServiceBean bean = service.read(in.getId());
		assertTrue(in.equals(bean), "Search a record");
	}

	@Test
	@DisplayName("Test update operation")
	void testUpdate() {
		ProductServiceBean bean = new ProductServiceBean(1L, "Product", "Product Description");
		service.update(in);
		assertTrue(in.equals(bean), "Update a record");
	}

	@Test
	@DisplayName("Test delete operation")
	void testDelete() {
		ProductServiceBean bean = new ProductServiceBean(1L, "Product", "Product Description");
		service.delete(in);
		assertTrue(in.equals(bean), "Delete a record");
	}

}
