package com.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	/*
	 * This method is used to add new products
	 */

	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
		LOGGER.info("Inside addProduct of ProductController");
		Product newProduct = productService.addProduct(product);
		LOGGER.info("Product added Successfully");
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(newProduct, HttpStatus.CREATED);
		LOGGER.info("Add product -END!");
		return responseEntity;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProducts() {
		LOGGER.info("Inside getAllProducts of ProductController");
		List<Product> allProducts = productService.getAllProduct();
		LOGGER.info("Product viewed Successfully");
		ResponseEntity<List<Product>> responseEntity = new ResponseEntity<List<Product>>(allProducts, HttpStatus.FOUND);
		LOGGER.info("Get Product -End");
		return responseEntity;
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> fetchProductById(@PathVariable("id") String productId) {
		LOGGER.info("Inside fetchProductById of ProductController");
		Product product = productService.getProductById(productId);
		LOGGER.info("Fetching Product");
		ResponseEntity<Product> responseEntity = new ResponseEntity<Product>(product, HttpStatus.FOUND);
		LOGGER.info("Fetch Product -END!");
		return responseEntity;
	}

	@PutMapping("/update")
	public ResponseEntity<Product> updateProduct(@Valid @RequestBody Product product) {
		LOGGER.info("Inside updateProduct of ProductController");
		Product updatedProduct = productService.updateProduct(product);
		LOGGER.info("Updating Product");
		ResponseEntity<Product> responseEntity = new ResponseEntity<Product>(updatedProduct, HttpStatus.CREATED);
		LOGGER.info("Update Product -END!");
		return responseEntity;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable("id") String productId) {
		LOGGER.info("Inside deleteProductById of ProductController");
		productService.deleteProductById(productId);
		LOGGER.info("Deleting Product");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Product deleted successfully",
				HttpStatus.OK);
		LOGGER.info("Delete Product -END!");
		return responseEntity;
	}

}
