package com.app.controler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.ProductEntity;
import com.app.exceptions.ProductNotFoundException;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

	@GetMapping("/{id}")
	public ResponseEntity<ProductEntity> getProduct(@PathVariable Integer id) {
		// Check if the product exists in the repository
		if (id != 100) {
			// If the product does not exist, throw the custom exception
			throw new ProductNotFoundException("Product with ID " + id + " not found");
		} else {
			return new ResponseEntity<ProductEntity>(new ProductEntity(id, "Java", 750),HttpStatus.OK);
		}
	}
}
