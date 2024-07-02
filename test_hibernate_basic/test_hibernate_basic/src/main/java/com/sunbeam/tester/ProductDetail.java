package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Locale.Category;
import java.util.Scanner;

import javax.management.relation.Role;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Products;


public class ProductDetail {
	
	public static void main(String[] args) {
		
		try (SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in))
		{
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter product id");
			System.out.println(dao.getProductDetailsById(sc.nextLong()));
		} //JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
