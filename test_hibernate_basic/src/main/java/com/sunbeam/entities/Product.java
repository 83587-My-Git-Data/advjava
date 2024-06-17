package com.sunbeam.entities;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // for auto id generation, using auto increment feature
	private Long id;
	@Enumerated(EnumType.STRING) // col type : varchar
	@Column(length = 20)
	private Category category;
	@Column(name = "product_name", length = 25, unique = true) // col name, varchar(25)
	private String productName;
	private double price;
	private int quantity;

	public Product() {
	}

	public Product(Category category, String productName, double price, int quantity) {
		this.category = category;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "Product [id=" + id + ", category=" + category + ", productName=" + productName + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
}
