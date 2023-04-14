package com.craftsman.catalogsvc;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.craftsman.catalogsvc.domain.model.CatalogServiceBean;
import com.craftsman.catalogsvc.services.ICatalogService;

@DisplayName("CatalogServiceTest")
@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CatalogServiceTest {

	@Autowired
	ICatalogService service;

	private static CatalogServiceBean in;
	
	@BeforeAll
	static void initAll() {
		in = new CatalogServiceBean(1L, "Product", "Product Description");
	}

	@Test
	@DisplayName("Test create operation")
	void testCreate() {
		CatalogServiceBean bean = new CatalogServiceBean(1L, "Product", "Product Description");
		service.create(in);
		assertTrue(in.equals(bean), "Insert a new record");
	}

	@Test
	@DisplayName("Test read operation")
	void testRead() {
		CatalogServiceBean bean = service.read(in.getId());
		assertTrue(in.equals(bean), "Search a record");
	}

	@Test
	@DisplayName("Test update operation")
	void testUpdate() {
		CatalogServiceBean bean = new CatalogServiceBean(1L, "Product", "Product Description");
		service.update(in);
		assertTrue(in.equals(bean), "Update a record");
	}

	@Test
	@DisplayName("Test delete operation")
	void testDelete() {
		CatalogServiceBean bean = new CatalogServiceBean(1L, "Product", "Product Description");
		service.delete(in);
		assertTrue(in.equals(bean), "Delete a record");
	}

}
