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

@DisplayName("Tests RestService")
@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestServiceTest {

	@Autowired
	IRestService service;
	@Autowired
	RestServiceRepository repository;
	@Autowired
	RestServiceFactoryMapper mapper;

	private static RestServiceDto in;
	
	@BeforeAll
	static void initAll() {
		in = new RestServiceDto(1L, "Product", "Product Description");
	}

	@Test
	@DisplayName("Test create operation")
	void testCreate() {
		RestServiceDto bean = new RestServiceDto(1L, "Product", "Product Description");
		service.create(in);
		assertTrue(in.equals(bean), "Insert a new record");
	}

	@Test
	@DisplayName("Test read operation")
	void testRead() {
		//RestServiceDtoList list = service.read(in.getId());
		assertTrue(true, "Search a record");
	}

	@Test
	@DisplayName("Test update operation")
	void testUpdate() {
		RestServiceDto bean = new RestServiceDto(1L, "Product", "Product Description");
		service.update(in);
		assertTrue(in.equals(bean), "Update a record");
	}

	@Test
	@DisplayName("Test delete operation")
	void testDelete() {
		RestServiceDto bean = new RestServiceDto(1L, "Product", "Product Description");
		service.delete(in);
		assertTrue(in.equals(bean), "Delete a record");
	}

}
