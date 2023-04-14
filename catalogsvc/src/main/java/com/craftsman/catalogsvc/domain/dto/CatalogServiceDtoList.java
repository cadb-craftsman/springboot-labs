package com.craftsman.catalogsvc.domain.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogServiceDtoList {

	private List<CatalogServiceDto> dtoList;

}
