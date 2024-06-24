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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
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
	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	
}
