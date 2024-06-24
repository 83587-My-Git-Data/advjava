package com.sunbeam.service;

import java.util.List;
import java.util.Optional;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Product;

public interface ProductsService {
	List<Product> getAllProducts();
	Product addProduct(Product product);
	ApiResponse updateProduct(Long id, Product product);
	Optional<Product> getProductDetailsById(Long id);
	void deleteProductById(Long id);
}
