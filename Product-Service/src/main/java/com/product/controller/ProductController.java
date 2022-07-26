package com.product.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.product.model.Product;
import com.product.service.ProductService;

/*
 * @Author: Gaurab Sah
 * Created on:2022-07-22
 */

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	/*
	 * This method is used to add new products
	 */

	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
		Product newProduct = productService.addProduct(product);
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(newProduct, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> allProducts = productService.getAllProduct();
		ResponseEntity<List<Product>> responseEntity = new ResponseEntity<List<Product>>(allProducts, HttpStatus.FOUND);
		return responseEntity;
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> fetchProductById(@PathVariable("id") String productId) {
		Product product = productService.getProductById(productId);
		ResponseEntity<Product> responseEntity = new ResponseEntity<Product>(product, HttpStatus.FOUND);
		return responseEntity;
	}

	@PutMapping("/update")
	public ResponseEntity<Product> updateProduct(@Valid @RequestBody Product product) {
		Product updatedProduct = productService.updateProduct(product);
		ResponseEntity<Product> responseEntity = new ResponseEntity<Product>(updatedProduct, HttpStatus.CREATED);
		return responseEntity;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable("id") String productId) {
		productService.deleteProductById(productId);
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Product deleted successfully",
				HttpStatus.OK);
		return responseEntity;
	}

}
