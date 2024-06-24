package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.service.ProductsService;

@Controller
@RequestMapping("/products")
public class ProductsController {
	@Autowired
	private ProductsService productsService;
	
	public ProductsController() {
		System.out.println("in ctor " + getClass());
	}
	
	@GetMapping("/view")
	public String renderProductsByCategory(ModelMap modelMap, @RequestParam String categoryName) { 
		System.out.println("in render Products by category: " + categoryName);
		modelMap.addAttribute("products_list", productsService.fetchProductsByCategory(categoryName));
		System.out.println("modelMap = " + modelMap);
		return "/products/view";
	}
}
