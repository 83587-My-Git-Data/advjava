package com.sunbeam.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	public HomePageController() {
		System.out.println("in ctor " + getClass());
	}

	@RequestMapping("/")
	public String renderHomePage(Model map) {
		System.out.println("in render home page" + map);
		map.addAttribute("ts", LocalDateTime.now());
		return "/index";
	}
}
