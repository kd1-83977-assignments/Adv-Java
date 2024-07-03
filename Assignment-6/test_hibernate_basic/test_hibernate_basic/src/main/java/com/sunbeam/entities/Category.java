package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category {

	@Column(name="category_name",length= 25,unique=true)
	private String categoryName;
	
	@Column(length= 50)
	private String description;
	
	@OneToMany(mappedBy= "category",
			cascade = CascadeType.ALL)
	private List<Product> products=new ArrayList<>();
	

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void addProduct(Product pro) {
		this.products.add(pro);
		
		pro.setCategory(this);
	}

	@Override
	public String toString() {
		return "Category [categoryName=" + categoryName + ", description=" + description + "]";
	}

	
	
	
	
}
