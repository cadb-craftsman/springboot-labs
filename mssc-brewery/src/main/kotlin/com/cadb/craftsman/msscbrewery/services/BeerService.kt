package com.cadb.craftsman.msscbrewery.services

import com.woowrale.msscbrewery.controller.model.BeerDto
import org.springframework.stereotype.Service
import java.util.*

interface BeerService {

    fun getBeerById(id:UUID): BeerDto
    fun saveBeer(beerDto: BeerDto): BeerDto
    fun updateBeer(beerId: UUID, beerDto: BeerDto): BeerDto
    fun deleteBeer(beerId: UUID)
}

@Service
class BeerServiceImpl: BeerService {

    override fun getBeerById(id: UUID): BeerDto {
        return BeerDto(id,"Galaxy Cat", "Pale Ale",1L)
    }

    override fun saveBeer(beerDto: BeerDto): BeerDto {
        return beerDto;
    }

    override fun updateBeer(beerId: UUID, beerDto: BeerDto): BeerDto {
        return beerDto;
    }

    override fun deleteBeer(beerId: UUID) {
       System.out.println("beerId: " + beerId)
    }
}