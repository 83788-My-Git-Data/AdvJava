package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import java.util.Locale.Category;
import java.util.Scanner;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Products;
import static com.sunbeam.utils.HibernateUtils.getFactory;

public class AddPtoduct {
	
public static void main(String[] args) {
		
		try (SessionFactory sf = getFactory();
				Scanner sc=new Scanner(System.in)
				) {
			//create dao instance
			ProductDao dao=new ProductDaoImpl();
			
			System.out.println("Enter User details -Category category, String name, \r\n"
					+ "			double price, int quantity, ");
			
			
			Products newProduct=new Products(com.sunbeam.entities.Category.valueOf(sc.next()), sc.next(), sc.nextDouble(), sc.nextInt());
			
			System.out.println(dao.addProduct(newProduct));
			
		} //JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
