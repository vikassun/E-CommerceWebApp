package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.service.CategoryService;
import com.ecommerce.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	CategoryService CategoryService;
	@Autowired
	ProductService productService;
	
	@GetMapping({"/","/home"})
	public String home(Model  model)
	{
		return "index";
	}
	@GetMapping({"/shop"})
	public String shop(Model  model)
	{
		model.addAttribute("categories",CategoryService.getAllCategory());
		model.addAttribute("products",productService.getAllProduct());
		return "shop";
	}
	@GetMapping({"/shop/category/{id}"})
	public String shopByCategoryId(Model  model,@PathVariable int id)
	{
		model.addAttribute("categories",CategoryService.getAllCategory());
		System.out.println("9999999999999999999999999999999999999999999999999999999999999999 =====" + id);
		model.addAttribute("products",productService.getAllProductByCategoryId(id));
		return "shop";
	}
}
