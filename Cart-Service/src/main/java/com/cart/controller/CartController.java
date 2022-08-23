package com.cart.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cart.model.Product;
import com.cart.service.CartService;

/*
 * @Author: Gaurab Sah
 * Created on:2022-07-25
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	RestTemplate restTemplate;

	private Logger LOGGER = LoggerFactory.getLogger(CartController.class);

	@PostMapping("/add")
	public Product addCart(@RequestBody Product product) {
		LOGGER.info("Inside addCart of cartController");

		LOGGER.info("Adding...");

		return restTemplate.postForObject("http://coupon-service/coupon/save", product, Product.class);
	}

	@GetMapping("/getAll")
	public List<Product> fetchAllCarts() {
		LOGGER.info("Inside fetchAllCarts of cartController");

		LOGGER.info("Fetching list of products");
		return Arrays.asList(restTemplate.getForObject("http://product-service/product/all", Product[].class));
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProductById(@PathVariable("id") String productId) {
		LOGGER.info("Inside deleteProductById of cartController");

		LOGGER.info("Deleting...");
		restTemplate.delete("http://product-service/product/delete/{Id}", productId, String.class);
		return "Product with Id = " + productId + " Deleted Successfully";
	}

}
