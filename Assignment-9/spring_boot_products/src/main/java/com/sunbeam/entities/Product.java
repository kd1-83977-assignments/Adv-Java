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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="products")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Product extends BaseEntity {
//	@Column(name="product_name",length= 25, unique=true)
	private int availQuantity;
	private double price;
	private String productName;
//	@Column(name="price")
	public Product(int availQuantity, double price, String productName) {
		super();
		this.availQuantity = availQuantity;
		this.price = price;
		this.productName = productName;
	}


//	@Column(name="available_quantity")
	
	
//	@ManyToOne //to avoid mappingException
//	//Product *--->1(many to one)
//	@JoinColumn(name="category_id",nullable = false)
//	private Category category;
//	

	
}
