package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Product;

public interface ProductsDao {
	List<Product> getProductsByCategory(String categoryName);
}
