package com.ganesh.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.model.Book;

@RestController
@RequestMapping("/book")
public class BookRestControler {

	@GetMapping("/{id}")
	public ResponseEntity<?> getBook(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		if (id == 100) {
			headers.add("found", "yes");
			ResponseEntity<Book> responce = new ResponseEntity<Book>(new Book(id, "Java", 550.5), headers,
					HttpStatus.OK);
			return responce;
		} else {
			headers.add("found", "no");
			String body = "SORRY! NOT FOUND BOOK";
			ResponseEntity<String> responce = new ResponseEntity<String>(body, headers, HttpStatus.OK);
			return responce;
		}

	}

	@GetMapping("/data")
	public ResponseEntity<String> showInfo() {
		// 1] Passing HTTP Status
		// ResponseEntity<String> responce = new ResponseEntity<String>(HttpStatus.OK);

		// 2] Passing Body + HTTP Status
		String body = "WELCOME TO APP";
		// ResponseEntity<String> responce = new ResponseEntity<String>(body,
		// HttpStatus.OK);

		// 3] Passing Header + Status
		HttpHeaders header = new HttpHeaders();
		header.add("MyAppOne", "Activated-Client");
		ResponseEntity<String> responce = new ResponseEntity<String>(header, HttpStatus.OK);
		return responce;
	}
}
