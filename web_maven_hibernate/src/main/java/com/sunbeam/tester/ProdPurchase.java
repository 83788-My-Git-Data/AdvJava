package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;


import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;

import com.sunbeam.entities.Category;

public class ProdPurchase {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			
			ProductDaoImpl productdao = new ProductDaoImpl();
			System.out.println("Enter  product to purchase - category , productId , Quntity ");
			
			System.out.println(productdao.purchaseById( sc.nextLong(), sc.nextLong(),sc.nextInt()));
		} // JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
