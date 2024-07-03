package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.service.ProductService;

@Controller
@RequestMapping("/posts")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/list")
	public String getProductsByRange(@RequestParam double minVal, @RequestParam double maxVal, Model modelAttributeMap) {
		
	System.out.println("min value is "+minVal+" max val is "+maxVal);
	
	modelAttributeMap.addAttribute("prod_list",productService.getProductByRange(minVal, maxVal));
	return "/posts/list";
	}
	
}
