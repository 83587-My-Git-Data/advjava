package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Product;

public interface ProductDao {
	
	String addProduct(Long categoryId, Product newProduct);
	List<Product> fetchAllProductsByCategory(Long categoryId);
	Product purchaseAProduct(Long productId);
	List<Product> fetchAllProducts();
	String purchaseProduct(Long productId, int qty);
}
