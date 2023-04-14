package com.craftsman.catalogsvc.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogServiceEntity {

	private Long id;
	private String name;
	private String description;

}
