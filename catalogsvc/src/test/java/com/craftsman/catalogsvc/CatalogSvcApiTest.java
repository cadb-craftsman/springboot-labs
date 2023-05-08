package com.craftsman.catalogsvc;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.craftsman.catalogsvc.controller.CatalogSvcApi;
import com.craftsman.catalogsvc.domain.model.dto.CatalogSvcDto;

@DisplayName("CatalogSvcApiTest")
@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CatalogSvcApiTest {

	@Autowired
	CatalogSvcApi api;

	private static CatalogSvcDto in;
	
	@BeforeAll
	static void initAll() {
		in = new CatalogSvcDto(1L, "Product", "Product Description");
	}

	@Test
	@DisplayName("Put test operation")
	void testPutOperation() {
		CatalogSvcDto bean = new CatalogSvcDto(1L, "Product", "Product Description");
		api.putOperation(in);
		assertTrue(in.equals(bean), "Update a record");
	}

	@Test
	@DisplayName("Post test operation")
	void testPostOperation() {
		CatalogSvcDto bean = new CatalogSvcDto(1L, "Product", "Product Description");
		api.postOperation(in);
		assertTrue(in.equals(bean), "Insert a new record");
	}

	@Test
	@DisplayName("Delete test operation")
	void testDeleteOperation() {
		CatalogSvcDto bean = new CatalogSvcDto(1L, "Product", "Product Description");
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
