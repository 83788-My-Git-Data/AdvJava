package com.sunbeam.dao;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunbeam.entities.Category;
import  com.sunbeam.entities.Products;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addProduct(Products product) {
		
		String msg="product not added successfully...!";
		Session session= getFactory().getCurrentSession();
		
		org.hibernate.Transaction tx = session.beginTransaction();
		try {
			Serializable productId=session.save(product);
			tx.commit();
			msg="product added successfully";
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		
		return msg;
	}

	@Override
	public Products getProductDetailsById(Long Id) {
		
		String msg="product not added successfully...!";
		Session session= getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		Products product = session.get(Products.class,Id);
		try {
			System.out.println("in gpdbi");
			
			tx.commit();
		
		}catch (RuntimeException e) {
			
			if(tx != null)
				tx.rollback();
			//re throw same exc to the caller
			throw e;
		}
		
		return product;
	}

	@Override
	public List<Products> getProductByPriceAndCat(Double maxprice, Double minprice, Category userCategory) {
		// TODO Auto-generated method stub
		System.out.println("innnnnn");
		String jpql="select p from Products p where p.price between :min and :max and p.category=:cat";
		List<Products> productslist=null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			productslist =session.createQuery(jpql,Products.class)
					.setParameter("min", minprice)
					.setParameter("max",maxprice)
					.setParameter("cat", userCategory)
					.getResultList();
			System.out.println("pppppp");
			System.out.println(productslist);
			System.out.println("ooooo");
			tx.commit();
			
		} catch (RuntimeException e) {
			// TODO: handle exception
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		return productslist;
	}

	@Override
	public String discountonCategory(Category cat, Double discount) {
		// TODO Auto-generated method stub
		String msg="discount apply failed...!";
		String jpql="update Products p set p.price=p.price-:discount where p.category=:cat";
		
		Session session=getFactory().getCurrentSession();
		//2. Begin a Tx
		Transaction tx=session.beginTransaction();
		try {
			int rows =session.createQuery(jpql)
					.setParameter("discount", discount)
					.setParameter("cat", cat)
					.executeUpdate();
			
			tx.commit();
			msg=rows+" discount applied successfully...!";
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			//re throw the exc to the caller
			throw e;
		}
		return msg;
	}

	@Override
	public String purchaseProduct(Long productId, int quntities) {
		// TODO Auto-generated method stub
		String msg="product out of stock";
		Session session=getFactory().getCurrentSession();
		//2. Begin a Tx
		Transaction tx=session.beginTransaction();
		try {
			Products prod=null;
			prod=session.get(Products.class, productId);
			if(prod.getQuantity()<=quntities)
			{
			prod.setQuantity(prod.getQuantity()-quntities);
			tx.commit();
			msg="purchased successfully...!";
			}
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			//re throw the exc to the caller
			throw e;
		}
		return msg;
	}

	@Override
	public String deleteProdByName(String prodName) {
		// TODO Auto-generated method stub
		String msg="producted delation failed.";
		String jpql="delete Products p where p.name=:prodName";
		Session session = getFactory().getCurrentSession();
		// 2. begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			int rows = session.createQuery(jpql)
					.setParameter("prodName", prodName)
					.executeUpdate();
			tx.commit();
			msg = "product deleted successfully" ;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exc to the caller
			throw e;
		}

		return msg;
		
	}

	
	
	
}

/*
 * 
 * public String addProduct(Products product)
	{
		
		
	}
 */
