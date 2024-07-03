package com.sunbeam.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Product;

@Repository
public class ProductDaoImpl implements ProductsDao {
	@Autowired
	private SessionFactory factory;
	
	@Override
	public List<Product> getProductByRange(Double minVal, Double maxVal) {
		String jpql="Select p from Product p where p.price between :min and :max";
		
		
		
		return factory.getCurrentSession().createQuery(jpql,Product.class)
				.setParameter("min", minVal).setParameter("max", maxVal).getResultList();
	}

}
