package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

public interface ProductDao {
	String addProductDetails(Product product);
	Product getProductDetailsById(Long productIdLong);
	List<Product> getProductDetailsByCategoryAndPrice(Category category, double priceStart, double priceEnd);
	String applyDiscount(Category category, double discount);
	String purchaseProduct(Long id, int quantity);
	String deleteProduct(String productName);
}

