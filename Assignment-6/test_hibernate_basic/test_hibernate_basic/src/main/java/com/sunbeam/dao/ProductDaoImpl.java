package com.sunbeam.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static com.sunbeam.utlis.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addProduct(Product product) {
		String msg="product not added";
		Session session =getFactory().getCurrentSession();
		
		Transaction tx =session.beginTransaction();
		
		try {
			Serializable id = session.save(product);
			tx.commit();
			msg="product added successfully, with id "+id;
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public Product getProductById(Long id) {
		
		Product product= null;
		
		Session session=getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		try {
			
			product=session.get(Product.class, id);
			
			tx.commit();
			
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		
		return product;
	}

	@Override
	public List<Product> getAllProductList(Category category, double minPrice, double maxPrice) {
		List<Product> list =null;
		String jpql ="select p from Product p where p.price between :min and :max and p.category =:cat";
		
		Session session=getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		try {
			list= session.createQuery(jpql, Product.class).setParameter("min", minPrice)
					.setParameter("max", maxPrice).setParameter("cat", category).getResultList();
			
			tx.commit();
			
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		
		return list;
	}

	@Override
	public String getCategoryProductList(Category category, double discount) {
		List<Product> list =null;
		String mesg ="Products not updated";
		
		String jpql ="update Product p set p.price = p.price - :disct where p.category =:cat";
		
		Session session=getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		try {
			int count= session.createQuery(jpql).setParameter("cat", category)
					.setParameter("disct", discount).executeUpdate();

			tx.commit();
			mesg="Number of rows updated are"+ count;
			
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		return mesg;
	}

	@Override
	public String buyProductInQuantity(Long id, int count) {
		String mesg ="Product not found";
		
		Product product;
		
		Session session=getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		try {
			
			product=session.get(Product.class, id);
			
			if(product.getAvailQuantity() > count) {
				product.setAvailQuantity(product.getAvailQuantity()-count);
			
			mesg= "Product purchased successfully";
			}
			else {
				mesg="no enough product available to buy";
			}
			
			tx.commit();
			
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		
		return mesg;
	}

	@Override
	public String deleteProductByName(String productName) {
		String mesg="No product deleted";
		String jpql ="delete from Product p where productName=:name";
		
		Session session=getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		try {
			
			session.createQuery(jpql).setParameter("name",productName).executeUpdate();
			
			tx.commit();
			mesg= "Product deleted successfully";
			
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		return mesg;
	}
	

	
}
