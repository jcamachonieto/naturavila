package com.naturavila.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/protected/hello")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}