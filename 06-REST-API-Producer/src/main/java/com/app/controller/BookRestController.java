package com.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/books")
@RestController
public class BookRestController {
	@GetMapping("/showA")
	public ResponseEntity<String> showMsg1() {
		return ResponseEntity.ok("WELCOME TO THE FIRST CALL TYPE:" + "GET");
	}

	@GetMapping("/showB/{id}/{name}")
	public ResponseEntity<String> showMsg2(@PathVariable Integer id, @PathVariable String name) {
		return ResponseEntity.ok("WELCOME TO THE FIRST CALL TYPE-GET" + id + "-" + "name");
	}
}
