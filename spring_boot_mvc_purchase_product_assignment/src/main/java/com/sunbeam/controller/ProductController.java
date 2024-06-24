package com.sunbeam.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	public ProductController() {
	}

	@GetMapping("/list")
		public String displayPurchaseItems(HttpSession session) {
			System.out.println("in display purchase items" + getClass());
			session.setAttribute("product_list",  productService.findAllProducts());
			return "/products/list";
		}

	@PostMapping("/list")
	public String buyAProduct(@RequestParam Long productId, @RequestParam int quantity, Model map,
			HttpSession session) {
		System.out.println("in Buy a Product" + getClass());
		String mesg = productService.purchaseProduct(productId, quantity);
		session.setAttribute("message", mesg);
		return "redirect:/products/list";
	}
}
