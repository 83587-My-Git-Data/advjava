package com.sunbeam.dao;

import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Console;
import java.util.List;

import com.sunbeam.entities.Category;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public String addCategory(Category category) {
		String mesg = "Add Category Failed!";
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			session.persist(category);
			tx.commit();
			mesg = "Category added succesfully";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return mesg;
	}

	@Override
	public List<Category> displayAllCategories() {
		List<Category> allCategories = null;
		String jpql = "select c from Category c";
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			allCategories = session.createQuery(jpql, Category.class).getResultList();
//			System.out.println(allCategories);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return allCategories;
	}

}
