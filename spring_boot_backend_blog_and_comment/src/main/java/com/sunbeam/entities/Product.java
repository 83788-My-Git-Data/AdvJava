package com.sunbeam.entities;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity

@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;

	
	@Column(name="name",length = 18)
	private String name  ;
	@Column(name="price")
	private double price ;
	@Column(name="quantity")
	private int quantity;
	
	public Product() {
		super();
	}
	public Product(  String name, double price, int quantity) {
		super();
		
		
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
