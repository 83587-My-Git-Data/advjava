package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
	@Column(length = 20, unique = true)
	private String name;
	private String description;
	/*
	 * @OneToMany - mandatory (otherwise mapping execution) if MappedBy is NOT added
	 * in a bi dir asso - hibernate creates additional table Default value of the
	 * cascade property = NONE ! i.e none f the operations will be cascaded from src
	 * -> targeted entity To specify - on save, update n delete use CascadeType.ALL
	 */
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// Category 1--->* Product (multiple products can be added under 1 Category)
	private List<Product> products = new ArrayList<>();

	public Category() {
	}

	public Category(String name, String description) {
		this.name = name;
		this.description = description;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + ", description=" + description + ", products=" + products + "]";
	}

	/*
	 * add helper method to establish bi dir asso b/w category and product
	 */
	public void addNewProduct(Product newProduct) {
		// parent(Category) --> child(Product)
		this.products.add(newProduct);
		// child --> parent
		newProduct.setCategory(this);
	}

}
