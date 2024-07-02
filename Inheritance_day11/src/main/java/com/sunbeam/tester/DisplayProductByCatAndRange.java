package com.sunbeam.tester;

import java.util.Scanner;
import static com.sunbeam.utils.HibernateUtils.getFactory;
import org.hibernate.SessionFactory;
import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;

public class DisplayProductByCatAndRange {

	public static void main(String[] args) {
		try (SessionFactory sf=getFactory();
				Scanner sc=new Scanner(System.in);
				){
			ProductDao dao=new ProductDaoImpl();
			System.out.println("enter begin end price and category");
			dao.getProductByPriceAndCat(sc.nextDouble(),sc.nextDouble(),Category.valueOf(sc.next().toUpperCase()))
			.forEach(System.out::println);
			System.out.println("hkkkk");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
