package com.craftsman.catalogsvc.domain.model.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogSvcEntity {

	private Long id;
	private String name;
	private String description;

}
