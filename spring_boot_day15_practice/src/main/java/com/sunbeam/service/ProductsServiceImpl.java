package com.sunbeam.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Product;

@Service
@Transactional
public class ProductsServiceImpl implements ProductsService {
	@Autowired
	private ProductDao productDao;
	

	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}


	@Override
	public Product addProduct(Product product) {
		Product persistentEntity =  productDao.save(product);
		return persistentEntity;
	}


	@Override
	public ApiResponse updateProduct(Long id, Product product) {
		String mesg = "Update Failed!";
		if(productDao.existsById(id)) {
			productDao.save(product);
			mesg = "Updated Successfully";
		}
		return new ApiResponse(mesg);
	}


	@Override
	public Optional<Product> getProductDetailsById(Long id) {
		return productDao.findById(id);
	}


	@Override
	public void deleteProductById(Long id) {
		if(productDao.existsById(id)) {
			productDao.deleteById(id);
		}
	}

}
