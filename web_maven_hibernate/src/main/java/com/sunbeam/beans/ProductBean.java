package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Product;

public class ProductBean {
	private String name;
	private double price;
	private int quantity;
	private long categoryId;
	private Long productId;
	// dependency - dao layer interface
	private ProductDao productDao;

	public ProductBean() {
		// creating dao instance
		productDao = new ProductDaoImpl();
		System.out.println("Product bean created...");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String addNewProduct() {
		System.out.println("in add product" + categoryId);
		// 1. create transient product
		Product product = new Product(name, price, quantity);
		// invoke dao's method
		return productDao.addProduct(categoryId, product);
	}

	public List<Product> getAllProducts() {
		return productDao.fetchAllProducts();
	}

	public List<Product> productsByCategory() {
		return productDao.fetchAllProductsByCategory(categoryId);
	}

	public Product purchaseAProduct() {
		System.out.println(productDao.purchaseAProduct(productId));
		return productDao.purchaseAProduct(productId);
	}
	
	public String purchaseProduct() {
		return productDao.purchaseProduct(productId);
	}
}
