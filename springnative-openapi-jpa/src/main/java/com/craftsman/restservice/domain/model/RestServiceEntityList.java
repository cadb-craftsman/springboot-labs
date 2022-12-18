package com.craftsman.restservice.domain.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestServiceEntityList {

	private List<RestServiceEntity> modelList;

}
