package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="categories")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Category extends BaseEntity{

	@Column(name="category_name",length= 25,unique=true)
	private String categoryName;	
	private String description;
//	@OneToMany(mappedBy= "category", cascade = CascadeType.ALL)//otherwise mappingException
//	//Category 1--->* Product(multiple products can be added under 1 categories
//	//cascading property by default = NONE(i.e. To specify- on save, update n delete)
//	private List<Product> products=new ArrayList<>();
//	

	


	
	
	
	
	
}
