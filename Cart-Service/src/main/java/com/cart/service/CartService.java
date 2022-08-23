package com.cart.service;

import java.util.List;

import com.cart.model.Cart;
import com.cart.model.Product;

public interface CartService {

	Cart addCart(Cart cart);

	void deleteCartById(String cartId);

	List<Cart> getAllCarts();

	// ----------------------------------------------------------------------------

//	void addCart(String userId);
//
//	String cartTotal(Cart cart);
//
//	List<Cart> getAllCarts();
//
//	Cart getCartById(String cartId);

	// Cart addToCart(Cart cart,String userId);

//	Cart addToCart(Product item, String userId);
//
//	Cart updateCart(Cart cart);

}
