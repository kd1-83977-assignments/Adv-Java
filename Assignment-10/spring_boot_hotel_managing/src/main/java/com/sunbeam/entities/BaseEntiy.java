package com.sunbeam.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntiy {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
}
