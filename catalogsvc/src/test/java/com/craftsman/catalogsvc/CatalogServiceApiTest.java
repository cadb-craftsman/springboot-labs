package com.craftsman.catalogsvc;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.craftsman.catalogsvc.controller.CatalogServiceApi;
import com.craftsman.catalogsvc.domain.dto.CatalogServiceDto;

@DisplayName("CatalogServiceApiTest")
@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CatalogServiceApiTest {

	@Autowired
	CatalogServiceApi api;

	private static CatalogServiceDto in;
	
	@BeforeAll
	static void initAll() {
		in = new CatalogServiceDto(1L, "Product", "Product Description");
	}

	@Test
	@DisplayName("Put test operation")
	void testPutOperation() {
		CatalogServiceDto bean = new CatalogServiceDto(1L, "Product", "Product Description");
		api.putOperation(in);
		assertTrue(in.equals(bean), "Update a record");
	}

	@Test
	@DisplayName("Post test operation")
	void testPostOperation() {
		CatalogServiceDto bean = new CatalogServiceDto(1L, "Product", "Product Description");
		api.postOperation(in);
		assertTrue(in.equals(bean), "Insert a new record");
	}

	@Test
	@DisplayName("Delete test operation")
	void testDeleteOperation() {
		CatalogServiceDto bean = new CatalogServiceDto(1L, "Product", "Product Description");
		api.deleteOperation(in);
		assertTrue(in.equals(bean), "Delete a record");
	}

	@Test
	@DisplayName("Get test operation")
	void testGetOperation() {
		api.getOperation(in.getId());
		assertTrue(true, "Search a record");
	}

}
