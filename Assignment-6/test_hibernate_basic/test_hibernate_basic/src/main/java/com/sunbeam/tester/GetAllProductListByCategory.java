package com.sunbeam.tester;

import static com.sunbeam.utlis.HibernateUtils.getFactory;

import java.util.Scanner;
import com.sunbeam.entities.Category;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;

public class GetAllProductListByCategory {

	public static void main(String[] args) {
		
		try (SessionFactory sf = getFactory();
				Scanner sc=new Scanner(System.in)
				) {
			ProductDao dao=new ProductDaoImpl();
			
			System.out.println("Enter Product 1.Catergory 2.Discount");
			System.out.println(
			dao.getCategoryProductList(Category.valueOf(sc.next()),sc.nextDouble()));
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
