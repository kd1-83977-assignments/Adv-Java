package com.sunbeam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//singleton n eager
@Controller//MANDATORY class level annotation to specify this is a spring 


public class HomePageController {

	public HomePageController() {
		System.out.println("in ctor "+getClass());
	}
	
	@RequestMapping("/")
	//key = '/'
	//value = 'com.sunbeam.controller.HomePageController.renderHomePage()'
	public String renderHomePage() {
		System.out.println("in render home page");
		return "/index";  //req handler returns LVS => D.S. -> View Resolver ->AVN(WEB-INF/views/index.jsp) ->
		//D.S. for th client to the view layer(JSP)
	}
}
