package com.cart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.model.Cart;
import com.cart.service.CartService;

/*
 * @Author: Gaurab Sah
 * Created on:2022-07-25
 */

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	private Logger LOGGER = LoggerFactory.getLogger(CartController.class);

	@PostMapping("/add")
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
		LOGGER.info("Inside addCart of cartController");
		Cart newCart = cartService.addCart(cart);
		LOGGER.info("Adding...");
		ResponseEntity<Cart> responseEntity = new ResponseEntity<Cart>(newCart, HttpStatus.CREATED);
		LOGGER.info("Added cart");
		return responseEntity;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Cart>> fetchAllCarts() {
		LOGGER.info("Inside fetchAllCarts of cartController");
		List<Cart> allCarts = cartService.getAllCarts();
		LOGGER.info("Fetching...");
		ResponseEntity<List<Cart>> responseEntity = new ResponseEntity<List<Cart>>(allCarts, HttpStatus.ACCEPTED);
		LOGGER.info("Fetch Cart -END!");
		return responseEntity;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable("id") int cartId) {
		LOGGER.info("Inside deleteProductById of cartController");
		cartService.deleteCartById(cartId);
		LOGGER.info("Deleting...");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Cart deleted successfully", HttpStatus.OK);
		LOGGER.info("Delete Cart -END!");
		return responseEntity;
	}

}
