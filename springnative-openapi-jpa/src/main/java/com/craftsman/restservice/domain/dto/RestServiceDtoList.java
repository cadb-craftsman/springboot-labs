package com.craftsman.restservice.domain.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestServiceDtoList {

	private List<RestServiceDto> dtoList;

}
