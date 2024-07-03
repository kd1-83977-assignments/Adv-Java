package com.sunbeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Product;
import com.sunbeam.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	public ProductController() {
		System.out.println("in ctor "+getClass());
	}
	
	@GetMapping
	public List<Product> getAllProducts(){
		
		return productService.getAllProducts();
		
	}
	
	@PostMapping
	@Operation(description = "Create New product")
	public ResponseEntity<?> addProduct(@RequestBody Product newProduct) {
		try {
			System.out.println("in controller"+newProduct);
			return ResponseEntity.status(HttpStatus.CREATED).body(productService.addNewProduct(newProduct));
		} catch (RuntimeException e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}

	}
	
}
