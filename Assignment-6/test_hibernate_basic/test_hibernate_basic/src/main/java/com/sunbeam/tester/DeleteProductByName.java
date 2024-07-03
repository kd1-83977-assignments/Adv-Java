package com.sunbeam.tester;

import static com.sunbeam.utlis.HibernateUtils.getFactory;

import java.util.Scanner;
import com.sunbeam.entities.Category;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;

public class DeleteProductByName {

	public static void main(String[] args) {
		
		try (SessionFactory sf = getFactory();
				Scanner sc=new Scanner(System.in)
				) {
			ProductDao dao=new ProductDaoImpl();
			
			System.out.println("Enter Product 1.product Name");
			System.out.println(
			dao.deleteProductByName( sc.next()));
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
