package com.cadb.craftsman.msscbrewery.controller

import com.cadb.craftsman.msscbrewery.services.BeerService
import com.woowrale.msscbrewery.controller.model.BeerDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.constraints.NotNull

@Validated
@RequestMapping("/api/v1/beer/")
@RestController
class BeerController {

    @Autowired
    lateinit var beerService: BeerService

    //GET get a beer by id.
    @GetMapping("/{beerId}")
    fun getBeer(@NotNull @PathVariable("beerId") beerId: UUID): ResponseEntity<BeerDto> {
        return ResponseEntity(beerService.getBeerById(beerId), HttpStatus.OK)
    }

    //POST create a new beer.
    @PostMapping
    fun handlePost(@NotNull @Validated @RequestBody beerDto: BeerDto): ResponseEntity<BeerDto> {
        val savedBeerDto = beerService.saveBeer(beerDto)
        var headers: HttpHeaders = HttpHeaders()
        headers.add("Location", savedBeerDto.id.toString())
        return ResponseEntity(headers, HttpStatus.CREATED)
    }

    //PUT update an existing beer.
    @PutMapping("/{beerId}")
    fun handleUpdate(
        @NotNull @PathVariable("beerId") beerId: UUID,
        @NotNull @Validated @RequestBody beerDto: BeerDto
    ): ResponseEntity<BeerDto> {
        beerService.updateBeer(beerId, beerDto)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    //DELETE delete an existing beer by Id
    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBeer(@NotNull @PathVariable("beerId") beerId: UUID) {
        beerService.deleteBeer(beerId)
    }
}