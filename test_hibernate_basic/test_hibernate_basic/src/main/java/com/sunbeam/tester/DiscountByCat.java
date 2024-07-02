package com.sunbeam.tester;

import org.hibernate.*;
import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Products;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;
import org.hibernate.SessionFactory;

public class DiscountByCat {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory();
			Scanner sc=new Scanner(System.in)
				) {
			
			ProductDao dao=new ProductDaoImpl();
			System.out.println("enter product category and discount");
			System.out.println(dao.discountonCategory(Category.valueOf(sc.next().toUpperCase()),sc.nextDouble()));
//			.forEach(System.out::println);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
