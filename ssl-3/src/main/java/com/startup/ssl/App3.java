package com.startup.ssl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App3 {
	
//	final static String KEYSTORE_PASSWORD = "password";

//	static
//	{
//		System.setProperty("javax.net.ssl.trustStore", App3.class.getClassLoader().getResource("truststore.jks").getFile());
//		System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASSWORD);
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(App3.class, args);
	}
}
