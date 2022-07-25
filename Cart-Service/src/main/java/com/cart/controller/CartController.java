package com.cart.controller;

import java.util.List;

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

	@PostMapping("/add")
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
		Cart newCart = cartService.addCart(cart);
		ResponseEntity<Cart> responseEntity = new ResponseEntity<Cart>(newCart, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Cart>> fetchAllCarts() {
		List<Cart> allCarts = cartService.getAllCarts();
		ResponseEntity<List<Cart>> responseEntity = new ResponseEntity<List<Cart>>(allCarts, HttpStatus.ACCEPTED);
		return responseEntity;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable("id") int cartId) {
		cartService.deleteCartById(cartId);
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Cart deleted successfully", HttpStatus.OK);
		return responseEntity;
	}

}
