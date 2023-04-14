package com.craftsman.catalogsvc.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogServiceBean {

	private Long id;
	private String name;
	private String description;

}
