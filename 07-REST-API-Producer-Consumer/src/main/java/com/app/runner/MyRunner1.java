package com.app.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class MyRunner1 implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// 1] CREATE URL
		String url = "http://localhost:8080/api/books/showA";
		// 2] CREATE REQUEST HEADER
		// 3] CREATE REQUEST BODY
		// 4] CREATE RESTTEMPLATE OBJECT
		RestTemplate template = new RestTemplate();
		// 5]
		ResponseEntity<String> responce = template.getForEntity(url, String.class);
		System.out.println(responce.getBody());
		System.out.println(responce.getHeaders());
		System.out.println(responce.getStatusCode().value());
	}

}
