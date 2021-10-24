package com.woowrale.msscbrewery.repository

import com.woowrale.msscbrewery.domain.Beer
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

public interface BeerRepository: PagingAndSortingRepository<Beer, UUID>