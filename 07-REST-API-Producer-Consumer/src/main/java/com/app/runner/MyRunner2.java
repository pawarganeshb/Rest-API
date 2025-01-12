package com.app.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class MyRunner2 implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		String URL = "localhost:8080/api/books/showB/{id}/{name}";
		// 2] CREATE REQUEST HEADER
		// 3] CREATE REQUEST BODY
		// 4] CREATE RESTTEMPLATE OBJECT
		RestTemplate template = new RestTemplate();
		// 5]
		ResponseEntity<String> responce = template.getForEntity(URL, String.class, 101, "Ganesh");
		System.out.println(responce.getBody());
		System.out.println(responce.getHeaders());
		System.out.println(responce.getStatusCode().value());
	}

}
