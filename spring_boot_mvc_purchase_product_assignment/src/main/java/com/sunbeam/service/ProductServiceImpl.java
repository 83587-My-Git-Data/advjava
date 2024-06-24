package com.sunbeam.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.ProductsDao;
import com.sunbeam.entities.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

@Autowired
private ProductsDao productsDao;
	
	@Override
	public List<Product> findAllProducts() {
		return productsDao.findAll();
	}

	@Override
	public String purchaseProduct(Long productId, int quantity) {
		String mesg = "Product Purchase Failed";
		Optional<Product> p = productsDao.findById(productId);
		if(p != null && p.get().getQuantity() >= quantity) {
			p.get().setQuantity(p.get().getQuantity() - quantity);
			mesg = "Product purchased";
		}
		return mesg;
	}

}
