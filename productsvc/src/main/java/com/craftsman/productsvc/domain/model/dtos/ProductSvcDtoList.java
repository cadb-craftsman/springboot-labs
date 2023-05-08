package com.craftsman.productsvc.domain.model.dtos;

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
