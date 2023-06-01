package com.craftsman.productsvcx.domain.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSvcDtoList {

	private List<ProductSvcDto> dtoList;

}
