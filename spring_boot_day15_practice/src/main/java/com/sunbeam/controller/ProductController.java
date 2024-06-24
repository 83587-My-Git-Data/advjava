package com.sunbeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Product;
import com.sunbeam.service.ProductsService;

import lombok.Delegate;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductsService productService;

	public ProductController() {
	}

	@GetMapping
	public List<Product> listAllProducts() {
		System.out.println("in List");
		return productService.getAllProducts();
	}

	@PostMapping
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product product) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id, product));
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}

	@GetMapping("/details/{id}")
	public ResponseEntity<?> getProductDetailsById(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(productService.getProductDetailsById(id));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteProductById(@PathVariable Long id) {
		try {
			productService.deleteProductById(id);
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Succesfully Deleted"));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
}
