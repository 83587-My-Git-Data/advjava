package com.sunbeam.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.ProductsDao;
import com.sunbeam.entities.Product;

@Service
@Transactional
public class ProductsServiceImpl implements ProductsService {
	@Autowired
	private ProductsDao productsDao;

	@Override
	public List<Product> fetchProductsByCategory(String catName) {
		System.out.println("in service layer " + getClass());
		return productsDao.getProductsByCategory(catName);
	}

}
