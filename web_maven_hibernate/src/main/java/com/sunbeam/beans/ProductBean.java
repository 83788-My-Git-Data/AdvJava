package com.sunbeam.beans;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Products;

public class ProductBean {

//	bind request parameter to java beans props
	
	private String name;
	private Double price;
	private int quantity;
	private long categoryId;
	private ProductDao productDao;
	
	public ProductBean() {
		// TODO Auto-generated constructor stub
		 productDao = new ProductDaoImpl();
		System.out.println("productbean created");
	}
	
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @return the quentity
	 */
	
	/**
	 * @return the categoryId
	 */
	public long getCategoryId() {
		return categoryId;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	@Override
	public String toString() {
		return "ProductBean [name=" + name + ", price=" + price + ", quentity=" + quantity + ", categoryId="
				+ categoryId + "]";
	}

//	public ProductBean(String name, Double price, int quentity, long categoryId) {
//		this.name = name;
//		this.price = price;
//		this.quentity = quentity;
//		this.categoryId = categoryId;
//	}
	
//	add B.L. method to add a new product
	
	public String addNewProduct() {
		System.out.println("in add product"+categoryId);
		Products product =new Products(name,price,quantity);
		
		return productDao.addProduct(categoryId, product);
				
	}
	
}
