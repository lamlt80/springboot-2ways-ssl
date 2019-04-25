package com.startup.ssl.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Controller {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getName")
	public String getName() throws URISyntaxException {
		
		log.info("SSL-1:getName start");
		
//		RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "https://localhost:2222/getName";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	  
		return result.getBody();
	}
	
	@GetMapping("/getName1")
	public String getName1() throws URISyntaxException {
		
		log.info("SSL-1:getName1 start");
		
		return "getName1 method";
	}

}
