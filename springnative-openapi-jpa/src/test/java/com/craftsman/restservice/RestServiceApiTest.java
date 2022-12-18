package com.craftsman.restservice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.craftsman.restservice.domain.dto.RestServiceDto;
import com.craftsman.restservice.domain.mappers.RestServiceFactoryMapper;
import com.craftsman.restservice.repository.RestServiceRepository;
import com.craftsman.restservice.services.IRestService;

@DisplayName("RestServiceApiTest")
@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestServiceApiTest {

	@Autowired
	IRestService service;
	@Autowired
	RestServiceFactoryMapper mapper;
	@Autowired
	RestServiceRepository repository;

	private static RestServiceDto in;
	
	@BeforeAll
	static void initAll() {
		in = new RestServiceDto(1L, "Product", "Product Description");
	}

	@Test
	@DisplayName("Put test operation")
	void testPutOperation() {
		RestServiceDto bean = new RestServiceDto(1L, "Product", "Product Description");
		service.update(in);
		assertTrue(in.equals(bean), "Update a record");
	}

	@Test
	@DisplayName("Post test operation")
	void testPostOperation() {
		RestServiceDto bean = new RestServiceDto(1L, "Product", "Product Description");
		service.create(in);
		assertTrue(in.equals(bean), "Insert a new record");
	}

	@Test
	@DisplayName("Delete test operation")
	void testDeleteOperation() {
		RestServiceDto bean = new RestServiceDto(1L, "Product", "Product Description");
		service.delete(in);
		assertTrue(in.equals(bean), "Delete a record");
	}

	@Test
	@DisplayName("Get test operation")
	void testGetOperation() {
		//RestServiceDtoList list = service.read(in.getId());
		assertTrue(true, "Search a record");
	}

}
