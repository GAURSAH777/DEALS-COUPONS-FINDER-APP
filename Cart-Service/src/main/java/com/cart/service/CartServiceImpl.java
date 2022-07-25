package com.cart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.exception.ProductAlreadyExistException;
import com.cart.exception.ProductNotFoundException;
import com.cart.model.Cart;
import com.cart.repositories.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart addCart(Cart cart) {
		Cart savedCart = cartRepository.findProductById(cart.getProducts());
		if (savedCart != null) {
			throw new ProductAlreadyExistException();
		} else
			return cartRepository.save(cart);
	}

	@Override
	public void deleteCartById(int cartId) {
		Optional<Cart> optionalCart = cartRepository.findById(cartId);
		if (optionalCart == null) {
			throw new ProductNotFoundException();
		}

	}

	@Override
	public List<Cart> getAllCarts() {
		List<Cart> carts = cartRepository.findAll();
		if (carts == null) {
			throw new ProductNotFoundException();
		} else
			return carts;
	}

}
