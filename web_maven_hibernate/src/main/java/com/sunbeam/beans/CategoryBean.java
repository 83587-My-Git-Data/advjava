package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.dao.CategoryDao;
import com.sunbeam.dao.CategoryDaoImpl;
import com.sunbeam.entities.Category;

public class CategoryBean {
	private String name;
	private String description;
	private CategoryDao categoryDao;

	public CategoryBean() {
		categoryDao = new CategoryDaoImpl();
		System.out.println("Category created");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String addNewCategory() {
		System.out.println("Adding category");
		Category category = new Category(name, description);
//		CategoryDao dao = new CategoryDaoImpl();
		return categoryDao.addCategory(category);
	}

	public List<Category> allCategories() {
		return categoryDao.displayAllCategories();
		
	}
}
