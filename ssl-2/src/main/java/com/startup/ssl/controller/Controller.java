package com.startup.ssl.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Controller {
	
	@Autowired
	@Qualifier("RestTemplate-SSL-3")
	private RestTemplate restTemplate;
	
	@GetMapping("/getName")
	public String getName() throws URISyntaxException {
		
		log.info("SSL-2 start");
		
		String name = "ssl-2";
	     
	    final String baseUrl = "https://localhost:3333/getName";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    name = result.getBody();
		
		return name;
	}
	
	@GetMapping("/getNameFromSSL1")
	public String getNameFromSSL1() throws URISyntaxException {
		
		log.info("SSL-2:getNameFromSSL1 start");
		
	    final String baseUrl = "https://localhost:1111/getName1";
	    URI uri = new URI(baseUrl);
	    
	    RestTemplate restTemplate = new RestTemplate();
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    String name = result.getBody();
		
		return name;
	}

}
