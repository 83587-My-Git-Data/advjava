package com.sunbeam.dao;

import com.sunbeam.entities.Product;
import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addProductDetails(Product product) {
		String msg = "Sorry The Product is not added!! :(";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try{
			Serializable productId = session.save(product);
			tx.commit();
			msg = "Product added Successfully :)" + productId;
		} catch (Exception e) {
			if(tx != null)
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
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return product;
		
	}
}
