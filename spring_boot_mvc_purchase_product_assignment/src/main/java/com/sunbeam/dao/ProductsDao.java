package com.sunbeam.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sunbeam.entities.Product;

public interface ProductsDao extends JpaRepository<Product, Long>{
	List<Product> findAll();
	Optional<Product> findById(Long productId);
}
