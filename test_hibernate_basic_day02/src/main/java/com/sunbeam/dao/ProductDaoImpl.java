package com.sunbeam.dao;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;
import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addProductDetails(Product product) {
		String msg = "Sorry The Product is not added!! :(";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Serializable productId = session.save(product);
			tx.commit();
			msg = "Product added Successfully :)" + productId;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public Product getProductDetailsById(Long productIdLong) {
		Product product = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			product = session.get(Product.class, productIdLong);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return product;

	}

	@Override
	public List<Product> getProductDetailsByCategoryAndPrice(Category category, double priceStart, double priceEnd) {
		String jpql = "select p from Product p where category = :cat and price between :start and :end";
		List<Product> products = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			products = session.createQuery(jpql, Product.class).setParameter("cat", category)
					.setParameter("start", priceStart).setParameter("end", priceEnd).getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return products;
	}

	@Override
	public String applyDiscount(Category category, double discount) {
		String mesg = "Sorry discount is not applied :( ";
		String jpql = "UPDATE Product p set p.price = (p.price - :dcnt) where category = :cat";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			int rows = session.createQuery(jpql).setParameter("dcnt", discount).setParameter("cat", category)
					.executeUpdate();
			tx.commit();
			mesg = "Discount applied :) ";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		return mesg;
	}

	@Override
	public String purchaseProduct(Long id, int quantity) {
		String mesg = "Purchase Unsuccessful :( ";
		Product product = null;
		
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			product = session.get(Product.class, id);
			if (product.getQuantity() > quantity) {
				mesg = "Purchase Successful :) ";
				product.setQuantity(product.getQuantity() - quantity);
			} else {
				mesg = "Product not in stock :( ";
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		return mesg;
	}

	@Override
	public String deleteProduct(String productName) {
		String mesg = "Delete Unsuccesssfull :( ";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String jpql = "SELECT p from Product p where productName = :prodName";
		try {
			Product product = session.createQuery(jpql, Product.class).setParameter("prodName", productName).getSingleResult();
			if(product != null) {
				session.delete(product);
				mesg = "Delete Successfull :) ";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return mesg;
	}
}
