package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="products")
public class Product extends BaseEntity {
	
	

	@Column(name="product_name",length= 25, unique=true)
	private String productName;
	
	private double price;
	@Column(name="available_quantity")
	private int availQuantity;
	
	@ManyToOne
	@JoinColumn(name="category_id",nullable = false)
	private Category category;
	
	public Product() {

	}

	public Product(String productName, double price, int availQuantity) {
		this.productName = productName;
		this.price = price;
		this.availQuantity = availQuantity;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailQuantity() {
		return availQuantity;
	}

	public void setAvailQuantity(int availQuantity) {
		this.availQuantity = availQuantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", price=" + price + ", availQuantity="
				+ availQuantity + "]";
	}

	

}
