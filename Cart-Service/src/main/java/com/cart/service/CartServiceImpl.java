package com.cart.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private Logger LOGGER = LoggerFactory.getLogger(CartServiceImpl.class);

	@Override
	public Cart addCart(Cart cart) {
		LOGGER.info("Add Cart -START!");
		Optional<Cart> savedCart = cartRepository.findById(cart.getCartId());
		if (savedCart.isPresent()) {
			LOGGER.info("Product Already Exist");
			throw new ProductAlreadyExistException();
		} else
			LOGGER.info("Saving...!!!");
		LOGGER.info("Add Cart -END!");
		return cartRepository.save(cart);
	}

	@Override
	public void deleteCartById(int cartId) {
		LOGGER.info("Delete Cart -START!");
		Optional<Cart> optionalCart = cartRepository.findById(cartId);
		if (optionalCart == null) {
			LOGGER.info("Product not found");
			throw new ProductNotFoundException();
		} else {
			LOGGER.info("Deleting Cart");
			cartRepository.deleteById(cartId);
			LOGGER.info("Delete Cart -END!");
		}

	}

	@Override
	public List<Cart> getAllCarts() {
		LOGGER.info("Fetch Cart -START!");
		List<Cart> carts = cartRepository.findAll();
		if (carts == null) {
			LOGGER.info("Product Not Found");
			throw new ProductNotFoundException();
		} else
			LOGGER.info("Fetching...");
		LOGGER.info("Fetch Cart -END!");
		return carts;
	}

}
