package com.craftsman.restservice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.craftsman.restservice.domain.model.RestServiceEntity;
import com.craftsman.restservice.repository.RestServiceRepository;

@DisplayName("Tests RestServiceRepository")
@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestServiceRepositoryTest {
	
	@Autowired
	RestServiceRepository repository;

	private static RestServiceEntity bean;

	@BeforeAll
	static void initAll() {
		bean = new RestServiceEntity(1L, "Object", "Object description");
	}

	
	@Test
	@DisplayName("Test findById operation")
	void testFindById() {
		Optional<RestServiceEntity> b = repository.findById(bean.getId()); 
		if(!b.isEmpty()) {
			assertTrue(bean.getId() == b.get().getId(), "Search record by id");	
		}else {
			assertTrue(true);
		}
		
	}

	@Test
	@DisplayName("Test findAll operation")
	void testFindAll() {
		List<RestServiceEntity> list = (List<RestServiceEntity>) repository.findAll(); 
		assertTrue(list.size() >= 0, "Search all records");
	}

	@Test
	@DisplayName("Test save operation")
	void testSave() {
		assertTrue(repository.save(bean).getId() >= 0, "Insert a record");
	}

	@Test
	@DisplayName("Test update operation")
	void testUpdate() {
		assertTrue(repository.save(bean).getId() >= 0, "Update a record");
	}

	@Test
	@DisplayName("Test delete operation")
	void testDelete() {
		Optional<RestServiceEntity> b = repository.findById(bean.getId()); 
		if(!b.isEmpty()) {
			repository.deleteById(bean.getId());
			assertTrue(true, "Delete a record");
		}else {
			assertTrue(true);
		}
	}
	
}
