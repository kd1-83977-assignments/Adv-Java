package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

public interface ProductDao {
	String addProduct(Product product);
	
	Product getProductById(Long id);
	
//	3.1 Display all the product details under specified category n between the given price range.
	List<Product> getAllProductList(Category category, double minPrice, double maxPrice );
	
//	3.2 Apply discount to all the products , from given category
//	i/p - product category
//	o/p a message how many products were discounted
	String getCategoryProductList(Category category, double discount );
	
//	3.3 Purchase a product
//	Product id n quantity
//	Validation - Check if product is availabe (check the available quantity )
//	Customer should be able to purchase a product if n only if it's available !
//	o/p a message indicating success or failure
	String buyProductInQuantity(Long id, int count);
	
	
//	3.4 Delete product details
//	i/p product name(unique)
//	o/p a message
	String deleteProductByName(String productName);
	
}
