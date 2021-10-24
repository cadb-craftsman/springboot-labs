package com.woowrale.msscbrewery.controller.client

import com.woowrale.msscbrewery.controller.model.BeerDto
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
internal class BreweryClientTest {

    @Autowired
    lateinit var breweryClient: BreweryClient

    @Test
    fun getBeerById() {
        var beerDto = breweryClient.getBeerById(UUID.randomUUID())
        System.out.println(beerDto.toString())
        assert(null != beerDto)
    }

    @Test
    fun saveNewBeer() {
        var url = breweryClient.saveNewBeer(BeerDto(UUID.randomUUID(), "Corona", "Oscura", 1L))
        System.out.println(url)
        assert(null != url)
    }

    @Test
    fun updateBeer() {
        val beerId = UUID.randomUUID()
        breweryClient.updateBeer(beerId, BeerDto(beerId, "Corona", "Clara", 1L))
    }

    @Test
    fun deleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID())
    }
}