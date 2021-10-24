package com.woowrale.msscbrewery.controller.client

import com.woowrale.msscbrewery.controller.model.BeerDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import java.net.URI
import java.util.*

@Component
@ConfigurationProperties(prefix = "mssc", ignoreUnknownFields = false)
class BreweryClient(@Autowired var restTemplateBuilder: RestTemplateBuilder) {

    //val BEER_PATH_V1 = "/api/v1/beer/"

    lateinit var apiPath: String
    lateinit var apiHost: String
    lateinit var restTemplate: RestTemplate

    init {
        restTemplate = restTemplateBuilder.build()
    }

    fun getBeerById(beerId: UUID): BeerDto{
        return restTemplate.getForObject(apiHost + apiPath + beerId.toString(), BeerDto::class)
    }

    fun saveNewBeer(beerDto: BeerDto): URI? {
        return restTemplate.postForLocation(apiHost + apiPath, beerDto)
    }

    fun updateBeer(beerId: UUID, beerDto: BeerDto){
        restTemplate.put(apiHost + apiPath + beerId.toString(), beerDto)
    }

    fun deleteBeer(beerId: UUID){
        restTemplate.delete(apiHost + apiPath + beerId)
    }
}