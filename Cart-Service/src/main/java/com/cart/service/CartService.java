package com.cart.service;

import java.util.List;

import com.cart.model.Cart;

public interface CartService {

	Cart addCart(Cart cart);

	void deleteCartById(int cartId);

	List<Cart> getAllCarts();

}
