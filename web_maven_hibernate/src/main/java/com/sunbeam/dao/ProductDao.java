package com.sunbeam.dao;

import com.sunbeam.entities.Products;

public interface ProductDao {

	String addProduct(Long categoryId,Products newProduct);
	
}
