package com.cart.service;

import com.cart.model.Cart;

public interface CartService {

	Cart addCart(Cart cart);

	void deleteCartById(int cartId);

	Cart getCart(int cartId);

}
