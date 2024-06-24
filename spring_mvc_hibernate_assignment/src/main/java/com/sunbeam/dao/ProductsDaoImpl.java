package com.sunbeam.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Product;

@Repository
public class ProductsDaoImpl implements ProductsDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public List<Product> getProductsByCategory(String categoryName) {
		String jpql = "select p from Product p where p.category.name = :cat";
		System.out.println("jpql fired");
		return sf.getCurrentSession().createQuery(jpql, Product.class).setParameter("cat", categoryName)
				.getResultList();
	}

}
