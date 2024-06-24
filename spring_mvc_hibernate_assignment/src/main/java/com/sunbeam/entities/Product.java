package com.sunbeam.entities;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
	//Product *--> 1 Category (many to one)
	@ManyToOne //Mandatory, otherwise mapping exception
	@JoinColumn(name="category_id", nullable = false)
	private Category category;
	@Column(name = "product_name", length = 25, unique = true) // col name, varchar(25)
	private String productName;
	private double price;
	private int quantity;

	public Product() {
	}

	public Product(String productName, double price, int quantity) {
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", price=" + price + ", quantity=" + quantity + "]";
	}

	
}
