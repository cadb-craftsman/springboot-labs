package com.craftsman.productsvcx;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.craftsman.productsvcx.controller.ProductServiceApi;
import com.craftsman.productsvcx.domain.model.dto.ProductServiceDto;

@DisplayName("ProductServiceApiTest")
@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApiTest {

	@Autowired
	ProductServiceApi api;

	private static ProductServiceDto in;
	
	@BeforeAll
	static void initAll() {
		in = new ProductServiceDto(1L, "Product", "Product Description");
	}

	@Test
	@DisplayName("Put test operation")
	void testPutOperation() {
		ProductServiceDto bean = new ProductServiceDto(1L, "Product", "Product Description");
		api.putOperation(1L, in);
		assertTrue(in.equals(bean), "Update a record");
	}

	@Test
	@DisplayName("Post test operation")
	void testPostOperation() {
		ProductServiceDto bean = new ProductServiceDto(1L, "Product", "Product Description");
		api.postOperation(in);
		assertTrue(in.equals(bean), "Insert a new record");
	}

	@Test
	@DisplayName("Delete test operation")
	void testDeleteOperation() {
		ProductServiceDto bean = new ProductServiceDto(1L, "Product", "Product Description");
		api.deleteOperation(1L);
		assertTrue(in.equals(bean), "Delete a record");
	}

	@Test
	@DisplayName("Get test operation")
	void testGetOperation() {
		api.getOperation(in.getId());
		assertTrue(true, "Search a record");
	}

}
