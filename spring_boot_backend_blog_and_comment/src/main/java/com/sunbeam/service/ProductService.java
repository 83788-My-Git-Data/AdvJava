package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Product;

public interface ProductService {

	Product addNewProduct(Product product);
	List<Product> getAllProducts();
	Product getProductDetail(Long ProductId);
	ApiResponse updateProductDetails(Long productId,Product existingProduct);
	ApiResponse deleteProductDetail(Long productId);
}
