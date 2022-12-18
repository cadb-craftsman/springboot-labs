package com.craftsman.restservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.craftsman.restservice.domain.model.RestServiceEntity;

@Repository
public interface RestServiceRepository extends CrudRepository<RestServiceEntity, Long> {
}
