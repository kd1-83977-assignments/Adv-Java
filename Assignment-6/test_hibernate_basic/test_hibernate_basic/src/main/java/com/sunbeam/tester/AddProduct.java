package com.sunbeam.tester;

import static com.sunbeam.utlis.HibernateUtils.getFactory;

import java.util.Scanner;
import com.sunbeam.entities.Category;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Product;

public class AddProduct {

	public static void main(String[] args) {
		
		try (SessionFactory sf = getFactory();
				Scanner sc=new Scanner(System.in)
				) {
			ProductDao dao=new ProductDaoImpl();
			System.out.println("Enter Product details");
			Product newProduct=new Product( Category.valueOf(sc.next().toUpperCase()), sc.next(), sc.nextDouble(), sc.nextInt());
			System.out.println(dao.addProduct(newProduct));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
