package com.sunbeam.service;

import java.util.List;

import com.sunbeam.entities.Product;

public interface ProductsService {
	List<Product> fetchProductsByCategory(String categoryName);
}
