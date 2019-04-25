package com.startup.ssl.controller;

import java.net.URISyntaxException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Controller {
	
	@GetMapping("/getName")
	public String getName() throws URISyntaxException {
		
		log.info("SSL-3 start");
		
		String name = "I am from SSL-3";
		return name;
	}
	
}
