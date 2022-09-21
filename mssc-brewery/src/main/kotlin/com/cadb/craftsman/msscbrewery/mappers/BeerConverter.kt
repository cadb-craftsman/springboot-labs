package com.cadb.craftsman.msscbrewery.mappers

import com.woowrale.msscbrewery.controller.model.BeerDto
import com.cadb.craftsman.msscbrewery.domain.Beer
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface BeerConverter {

    @Mapping(source = "id", target = "id")
    fun convertToDto(beer: Beer): BeerDto
}