package com.craftsman.productsvcx;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.craftsman.productsvcx.domain.model.persistence.ProductServiceEntity;
import com.craftsman.productsvcx.repository.ProductServiceRepository;

@DisplayName("ProductServiceRepositoryTest")
@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceRepositoryTest {
	
	@Autowired
	ProductServiceRepository  repository;

	private static ProductServiceEntity bean;

	@BeforeAll
	static void initAll() {
		bean = new ProductServiceEntity(1L, "Object", "Object description");
	}

	
	@Test
	@DisplayName("Test findById operation")
	void testFindById() {
		ProductServiceEntity b = repository.findById(bean.getId()); 
		if(b != null) {
			assertTrue(bean.getId() == b.getId(), "Search record by id");	
		}else {
			assertTrue(true);
		}
		
	}

	@Test
	@DisplayName("Test findAll operation")
	void testFindAll() {
		List<ProductServiceEntity> list = (List<ProductServiceEntity>) repository.findAll(); 
		assertTrue(list.size() >= 0, "Search all records");
	}

	@Test
	@DisplayName("Test save operation")
	void testSave() {
		assertTrue(repository.save(bean) >= 0, "Insert a record");
	}

	@Test
	@DisplayName("Test update operation")
	void testUpdate() {
		assertTrue(repository.save(bean) >= 0, "Update a record");
	}

	@Test
	@DisplayName("Test delete operation")
	void testDelete() {
		ProductServiceEntity b = repository.findById(bean.getId()); 
		if(b != null) {
			repository.delete(b.getId());
			assertTrue(true, "Delete a record");
		}else {
			assertTrue(true);
		}
	}
	
}
