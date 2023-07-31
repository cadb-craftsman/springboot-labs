package com.craftsman.productsvcx.domain.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageException {

    private String message;
    private String cause;
	
}

