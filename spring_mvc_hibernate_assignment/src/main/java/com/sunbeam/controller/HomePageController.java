package com.sunbeam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	public HomePageController() {
		System.out.println("in ctor " + getClass());
	}

	@RequestMapping("/")
	public String renderHomePage() {
		System.out.println("in render home page");
		return "/index";
	}
}
