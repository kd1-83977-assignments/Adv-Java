package com.sunbeam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class TestController {

	public TestController() {
		System.out.println("in ctor "+getClass());
	}
	
	@GetMapping("/multipy") // @RequestMapping(method=GET)
	public String multipyNos(Model modelMap,@RequestParam int num1, @RequestParam int num2) {
		
		/*
		 * @RequestParam - method args level annotation
		 * it is for data binding (in parsing) incoming request param -> method argument
		 * @RequestParam(name="num2") int nums22
		 */
		System.out.println("in multiply"+modelMap+" "+num1+" "+num2);
		modelMap.addAttribute("multiply_result",num1*num2);
		
		return "/test/result"; //AVN :
	}
}
