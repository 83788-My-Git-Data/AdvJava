package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Categories")
public class Category extends BaseEntity {
@Column(length = 20, unique = true)
private String name;
private String description;
//Category 1--->*Products

@OneToMany(mappedBy = "productCategory",
cascade=CascadeType.ALL)
private List<Products> products = new ArrayList<>();

public Category() {

}
public Category(String name, String description) {
super();
this.name = name;
this.description = description;
}

public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getDescription() {
return description;
}
public void setDescription(String description) {
this.description = description;
}
@Override
public String toString() {
return "Category [name=" + name + ", description=" + description + "]";
}

public void addProduct(Products product)
{
	this.products.add(product);
	product.setProductCategory(this);
}

}
