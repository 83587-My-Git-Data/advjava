package com.sunbeam.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Product extends BaseEntity {
	// Product *--> 1 Category (many to one)
//	@ManyToOne // Mandatory, otherwise mapping exception
//	@JoinColumn(name = "category_id", nullable = false)
//	private Category category;
	@Column(name = "product_name", length = 25, unique = true) // col name, varchar(25)
	private String productName;
	private double price;
	private int quantity;

	public Product(String productName, double price, int quantity) {
		super();
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
}
