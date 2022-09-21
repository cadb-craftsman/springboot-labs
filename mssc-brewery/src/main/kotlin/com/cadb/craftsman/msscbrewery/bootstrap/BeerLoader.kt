package com.cadb.craftsman.msscbrewery.bootstrap

import com.cadb.craftsman.msscbrewery.domain.Beer
import com.cadb.craftsman.msscbrewery.repository.BeerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.sql.Timestamp
import java.util.*

@Component
class BeerLoader : CommandLineRunner {

    @Autowired
    lateinit var beerRepository: BeerRepository

    override fun run(vararg args: String?) {
        loadBeerObjects()
    }

    private fun loadBeerObjects() {
        beerRepository.save(
            Beer(
                id = UUID.randomUUID(),
                version = 0,
                createDate = Timestamp(Date().time),
                lastModifiedDate = Timestamp(Date().time),
                beerName = "Mango Bobs",
                beerStyle = "IPA",
                quantityToBrew = 200,
                minOnHand = 20,
                upc = 337000001L,
                price = BigDecimal("12.95")
            )
        )

        beerRepository.save(
            Beer(
                id = UUID.randomUUID(),
                version = 0,
                createDate = Timestamp(Date().time),
                lastModifiedDate = Timestamp(Date().time),
                beerName = "Galaxy Cat",
                beerStyle = "PALE_ALE",
                quantityToBrew = 200,
                minOnHand = 20,
                upc = 337000001L,
                price = BigDecimal("10.95")
            )
        )
    }
}