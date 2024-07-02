package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Products;

public interface ProductDao {

	String addProduct(Products product);
	Products getProductDetailsById(Long userId);
	List<Products> getProductByPriceAndCat(Double maxprice,Double minprice, Category userCategory);
	String discountonCategory(Category cat,Double discount);
	String purchaseProduct(Long productId,int quntities);
	String deleteProdByName(String prodName);
}
