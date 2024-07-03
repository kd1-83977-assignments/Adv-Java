package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity


@Table(name="products")
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING) //col type : varchar
	@Column(length = 20)
	private Category category;
	
	@Column(length = 20,unique=true)//varchar(20), unique constraint
	private String product_name;
	
	@Column(name="price")
	private double price;
	
	@Column
	private int availableQuantity;

	
	
	public Product() {
		
		// TODO Auto-generated constructor stub
	}


	public Product(Long id, Category category, String product_name, double price, int availableQuantity) {
		
		this.id = id;
		this.category = category;
		this.product_name = product_name;
		this.price = price;
		this.availableQuantity = availableQuantity;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getAvailableQuantity() {
		return availableQuantity;
	}


	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", product_name=" + product_name + ", price=" + price
				+ ", availableQuantity=" + availableQuantity + "]";
	}
	

}
