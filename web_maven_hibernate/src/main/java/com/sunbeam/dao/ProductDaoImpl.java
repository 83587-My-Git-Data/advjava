package com.sunbeam.dao;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.*;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addProduct(Long categoryId, Product newProduct) {
		String mesg = "Add Product Failed";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Category category = session.get(Category.class, categoryId);
			if (category != null) {
				// valid category persistent
				// 4. Establish bi dir asso by category and product
				category.addNewProduct(newProduct); // state from the persistent Entity(category) is changed.
//						session.persist(newProduct); // Is this required ???? NO
			}
			tx.commit();
			mesg = "Product Added Successfully!";
			/*
			 * session.flush() -> dirty checking -> category is modified -> new product
			 * entity added. hib : inserts the product
			 */
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public List<Product> fetchAllProductsByCategory(Long categoryId) {
		List<Product> products = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Category category = session.get(Category.class, categoryId);
			products = category.getProducts();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		System.out.println(products.isEmpty());
		return products;
	}

	@Override
	public Product purchaseAProduct(Long productId) {
		Product product = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			product = session.get(Product.class, productId);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return product;
	}

	@Override
	public List<Product> fetchAllProducts() {
		List<Product> products = null;
		String jpql = "Select p from Product p";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			products = session.createQuery(jpql, Product.class).getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return products;
	}

	public String purchaseProduct(Long productId, int qty) {
		String mesg = "Product addition failed";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Product p = session.get(Product.class, productId);
			if (p != null && p.getQuantity() >= qty) {
				
			}
			mesg = "Product Purchased Successfully";
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
