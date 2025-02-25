package com.ganesh.rest.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductsRestController {

	// POST method to simulate saving a product
	@PostMapping
	public ResponseEntity<String> saveProduct() {
		return new ResponseEntity<String>("Product saved successfully!", HttpStatus.CREATED);
	}

	// GET method to simulate fetching products
	@GetMapping("/fetch")
	public ResponseEntity<String> getProduct() {
		return new ResponseEntity<String>("Product details fetched successfully!", HttpStatus.OK);
	}

	// PUT method to simulate updating a product
	@PutMapping("/{productId}")
	public ResponseEntity<String> updateProduct(@PathVariable("productId") Long productId) {
		return new ResponseEntity<String>("Product with ID " + productId + " updated successfully!", HttpStatus.OK);
	}

	// DELETE method to simulate deleting a product
	@DeleteMapping("/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") Long productId) {
		return new ResponseEntity<String>("Product with ID " + productId + " deleted successfully!",
				HttpStatus.NO_CONTENT);
	}
}
