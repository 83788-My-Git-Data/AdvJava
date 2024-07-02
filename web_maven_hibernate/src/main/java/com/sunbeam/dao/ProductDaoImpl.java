package com.sunbeam.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static com.sunbeam.utils.HibernateUtils.getFactory;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Products;


public class ProductDaoImpl implements ProductDao {

	@Override
	public String addProduct(Long categoryId, Products newProduct) {
		// TODO Auto-generated method stub
		System.out.println("Inside ProductDao Add: ");
		Session session = getFactory().getCurrentSession();
			String msg="adding product";
			Transaction tx = session.beginTransaction();
			try {
				// get category ref from it's id
				Category category = session.get(Category.class, categoryId);
				System.out.println("Inside ProductDao Add(): "+category);
				if (category != null ) {
					category.addProduct(newProduct);
					session.persist(newProduct);
				}
				tx.commit();// Hibernate performs - auto dirty checking -sees new blog post entity -> insert
							// query
				msg="added product";
			} catch (RuntimeException e) {
				if (tx != null)
					tx.rollback();
				// re throw the exc to the caller
				throw e;
			}
			return msg;
		}

	public String purchaseById(Long CatId,Long ProductId,int Quntities)
	{
		String msg="stock not availavle";
		Products prod=null;
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			prod=session.get(Products.class, ProductId);
			int remainQuntity=prod.getAvailableQuantity()-Quntities;
			if(prod!=null && remainQuntity>0 )
			{
				prod.setAvailableQuantity(prod.getAvailableQuantity()-Quntities);
				msg="purchased successfully";
				tx.commit();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		return msg;
	}
}

//	@Override
//public String addProduct(Long categoryId,Products newProduct) {
//		System.out.println("Inside ProductDao Add: ");
//Session session = getFactory().getCurrentSession();
//	String msg="adding product";
//	Transaction tx = session.beginTransaction();
//	try {
//		// get category ref from it's id
//		Category category = session.get(Category.class, categoryId);
//		System.out.println("Inside ProductDao Add(): "+category);
//		if (category != null ) {
//			category.addProduct(newProduct);
//			session.persist(newProduct);
//		}
//		tx.commit();// Hibernate performs - auto dirty checking -sees new blog post entity -> insert
//					// query
//		msg="added product";
//	} catch (RuntimeException e) {
//		if (tx != null)
//			tx.rollback();
//		// re throw the exc to the caller
//		throw e;
//	}
//	return msg;
//}

