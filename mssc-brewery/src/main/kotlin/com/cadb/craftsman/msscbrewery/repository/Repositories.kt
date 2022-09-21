package com.cadb.craftsman.msscbrewery.repository

import com.cadb.craftsman.msscbrewery.domain.Beer
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

public interface BeerRepository: PagingAndSortingRepository<Beer, UUID>