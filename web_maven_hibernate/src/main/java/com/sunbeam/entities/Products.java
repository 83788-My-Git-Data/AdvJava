package com.sunbeam.entities;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="products")
public class Products extends BaseEntity{
	
	@Column(length = 20,name = "product_Name",unique = true)
	private String productName;
	private double price;
	@Column(name = "available_Quantity")
	private int availableQuantity;
	//Product *--->1Category(many-to-one)
	@ManyToOne
	@JoinColumn(name="category_id",nullable = false)
	private Category productCategory;
	
	
	public Products() {
		super();
	}
	public Products(String productName, double price, int availableQuantity) {
		this.productName = productName;
		this.price = price;
		this.availableQuantity = availableQuantity;
	}
	public Products(Long id, Category category, String productName, double price, int availableQuantity,
			Category productCategory) {
		super(id);
	
		this.productName = productName;
		this.price = price;
		this.availableQuantity = availableQuantity;
		this.productCategory = productCategory;
	}
	@Override
	public String toString() {
		return "Products [  productName=" + productName + ", price=" + price
				+ ", availableQuantity=" + availableQuantity + ", productCategory=" + productCategory + "]";
	}
	
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the availableQuantity
	 */
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	/**
	 * @param availableQuantity the availableQuantity to set
	 */
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	/**
	 * @return the productCategory
	 */
	public Category getProductCategory() {
		return productCategory;
	}
	/**
	 * @param productCategory the productCategory to set
	 */
	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}
	public Products(Long id) {
		super(id);
	}
	
	
	
}
