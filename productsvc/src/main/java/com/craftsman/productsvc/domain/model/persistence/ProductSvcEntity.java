package com.craftsman.productsvc.domain.model.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSvcEntity {

	private Long id;
	private String name;
	private String description;

}
