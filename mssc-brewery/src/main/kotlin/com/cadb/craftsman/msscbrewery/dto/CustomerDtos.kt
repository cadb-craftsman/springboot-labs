package com.woowrale.msscbrewery.controller.model

import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class CustomerDto(
    @NotNull
    var id: UUID,
    @NotBlank
    @Size(min = 3, max = 100)
    var name: String,
    @NotNull
    var age: Int
)