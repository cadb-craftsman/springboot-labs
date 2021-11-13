package com.woowrale.msscbrewery.mappers

import com.woowrale.msscbrewery.controller.model.BeerDto
import com.woowrale.msscbrewery.domain.Beer
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface BeerConverter {

    @Mapping(source = "id", target = "id")
    fun convertToDto(beer: Beer): BeerDto
}