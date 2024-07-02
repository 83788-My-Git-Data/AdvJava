package com.sunbeam.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sunbeam.custom_exception.ResourceNotFoundException;
import com.sunbeam.dao.ProductDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Product;

import net.bytebuddy.asm.Advice.Return;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public Product addNewProduct(Product product) {
		Product persistentProduct = productDao.save(product);
		return persistentProduct;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public Product getProductDetail(Long ProductId) {
		// TODO Auto-generated method stub
		return productDao.findById(ProductId).orElseThrow(()->new ResourceNotFoundException("Invalid product...!"));
	}

	@Override
	public ApiResponse updateProductDetails(Long productId, Product existingProduct) {
		// TODO Auto-generated method stub
		String msg="Product Updation Failed : invalid id !!!!";
		if(productDao.existsById(productId))
		{
			productDao.save(existingProduct);
			msg="Updated product details";
		}
		
		return new ApiResponse(msg);
	}
	
@Override
public ApiResponse deleteProductDetail(Long productId)
{
	if(productDao.existsById(productId))
	{
		productDao.deleteById(productId);
		return new ApiResponse("delete product details");
		
	}
	return new ApiResponse("product deletion faild");
}
	
}
