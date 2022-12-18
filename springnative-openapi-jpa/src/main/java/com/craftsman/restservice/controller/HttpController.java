package com.craftsman.restservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HttpController {

	/**
	 * Index.
	 *
	 * @return the string
	 */
	@GetMapping("/")	
	public String index() {
		return "/openapi/swagger-ui.html";
	}

}
