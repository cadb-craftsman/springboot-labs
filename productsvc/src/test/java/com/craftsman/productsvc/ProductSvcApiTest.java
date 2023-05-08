package com.craftsman.productsvc;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.craftsman.productsvc.controller.ProductSvcApi;
import com.craftsman.productsvc.domain.model.dtos.ProductSvcDto;

@DisplayName("ProductSvcApiTest")
@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductSvcApiTest {

	@Autowired
	ProductSvcApi api;

	private static ProductSvcDto in;
	
	@BeforeAll
	static void initAll() {
		in = new ProductSvcDto(1L, "Product", "Product Description");
	}

	@Test
	@DisplayName("Put test operation")
	void testPutOperation() {
		ProductSvcDto bean = new ProductSvcDto(1L, "Product", "Product Description");
		api.putOperation(in);
		assertTrue(in.equals(bean), "Update a record");
	}

	@Test
	@DisplayName("Post test operation")
	void testPostOperation() {
		ProductSvcDto bean = new ProductSvcDto(1L, "Product", "Product Description");
		api.postOperation(in);
		assertTrue(in.equals(bean), "Insert a new record");
	}

	@Test
	@DisplayName("Delete test operation")
	void testDeleteOperation() {
		ProductSvcDto bean = new ProductSvcDto(1L, "Product", "Product Description");
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
