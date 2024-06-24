package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Category;

public interface CategoryDao {
	String addCategory(Category category);
	List<Category> displayAllCategories();
}
