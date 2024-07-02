package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;

import static com.sunbeam.utils.HibernateUtils.getFactory;
import java.util.Scanner;


public class DeleteProdByName {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			// create dao instance
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter product name for deleting the product details");
			System.out.println(dao.deleteProdByName(sc.next()));
		} // JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
