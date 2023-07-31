package com.craftsman.frontend.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FrontViewDto {

	@NotNull(message = "El id no puede ser nulo.")
	@Positive(message = "El id debe ser un numero igual o superior a uno.")
	private Long id;
	@NotBlank(message = "El nombre no puede estar vacio.")
	private String name;
	@NotBlank(message = "La descripcion no puede estar vacia.")
	private String description;

}
