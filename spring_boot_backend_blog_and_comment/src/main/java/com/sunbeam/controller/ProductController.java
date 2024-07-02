package com.sunbeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Product;
import com.sunbeam.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	public ProductController()
	{
		System.out.println("in ctor"+getClass());
	}
	
	@PostMapping
	@Operation(description="create new product")
	public ResponseEntity<?> addProduct(@RequestBody Product newProduct)
	{
		
		System.out.println("inadd product:"+newProduct);
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(productService.addNewProduct(newProduct));
		} catch (RuntimeException e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new com.sunbeam.dto.ApiResponse(e.getMessage()));
		}
	}
	
	
	@GetMapping
	public List<Product> getAllProducts()
	{
		System.out.println("in list");
		return productService.getAllProducts();
	}
	
	@GetMapping("/{prodId}")
	public ResponseEntity<?> getProductDetails(@PathVariable Long prodId)
	{
		System.out.println("in get Prod"+ prodId);
		try {
			return ResponseEntity.ok(productService.getProductDetail(prodId));
		} catch (RuntimeException e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));

		}
	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<?> updateProduct(@PathVariable Long productId,@RequestBody Product product)
	{
		System.out.println("in update"+productId+" "+product);
		
		return ResponseEntity.ok(productService.updateProductDetails(productId, product));
	}
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long productId)
	{
		return ResponseEntity.ok(productService.deleteProductDetail(productId));
	}
}
