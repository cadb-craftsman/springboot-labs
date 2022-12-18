package com.craftsman.restservice.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestServiceDto {

	@NotNull(message = "El id no puede ser nulo.")
	@Positive(message = "El id debe ser un numero igual o superior a uno.")
	private Long id;
	@NotBlank(message = "El nombre no puede estar vacio.")
	private String name;
	@NotBlank(message = "La descripcion no puede estar vacia.")
	private String description;

}
