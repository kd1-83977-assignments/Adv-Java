package com.sunbeam.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.ProductsDao;
import com.sunbeam.entities.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	SessionFactory factory;
	
	@Autowired
	private ProductsDao productdao;

	@Override
	public List<Product> getProductByRange(Double minVal, Double maxVal) {
		
		return productdao.getProductByRange(minVal, maxVal);
		
	}

}
