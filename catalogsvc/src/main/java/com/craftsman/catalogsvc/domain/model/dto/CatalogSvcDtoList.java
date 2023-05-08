package com.craftsman.catalogsvc.domain.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogSvcDtoList {

	private List<CatalogSvcDto> dtoList;

}
