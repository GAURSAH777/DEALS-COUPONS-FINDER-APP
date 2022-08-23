package com.cart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.exception.ProductAlreadyExistException;
import com.cart.exception.ProductNotFoundException;
import com.cart.model.Cart;
import com.cart.model.Product;
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
	public void deleteCartById(String cartId) {
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
	
	
	//----------------------------------------------------------------------------------

//	@Autowired
//	RestTemplate restTemplate;

//	@Override
//	public Cart getCartById(String id) {
//		return cartRepo.findBycartId(id);
//	}
//
//	@Override
//	public List<Cart> getAllCarts() {
//		return cartRepo.findAll();
//	}
//
//	@Override
//	public void addCart(String userId) {
//		cartRepo.save(new Cart(userId,new ArrayList<Product>(),"0"));
//	}
//
//	@Override
//	public Cart addToCart(Product item, String userId) {
//		boolean isQuantityUpdated = false;
//		Cart cartFromDb = cartRepo.findBycartId(userId);
//		item = getPriceOfItem(item);
//
//		for (Items dbCartItem : cartFromDb.getItems()) {
//			if (item.getProductId().equals(dbCartItem.getProductId())) {
//				dbCartItem.setQuantity(item.getQuantity() + dbCartItem.getQuantity());
//				isQuantityUpdated = true;
//				break;
//			}
//		}
//
//		if (isQuantityUpdated == false) {
//			cartFromDb.getItems().add(item);
//			cartFromDb.setItems(cartFromDb.getItems());
//		}
//		cartFromDb.setTotalPrice(cartTotal(cartFromDb));
//		return cartRepo.save(cartFromDb);
//	}
//
//	@Override
//	public Cart updateCart(Cart tempCart) {
//		tempCart = getPriceOfItems(tempCart);
//		tempCart.setTotalPrice(cartTotal(tempCart));
//		return cartRepo.save(tempCart);
//	}
//
//	// helper Methods
//	// --------------------------------------------------------------------
//	@Override
//	public double cartTotal(Cart cart) {
//		double totalCartValue = cart.getItems().stream()
//				.flatMapToDouble(i -> DoubleStream.of(i.getPrice() * i.getQuantity())).sum();
//		return totalCartValue;
//	}
//
//	private Cart getPriceOfItems(Cart cart) {
//		cart.getItems().stream().forEach(i -> {
//			i.setPrice(getDeocodedUrl(i).getPrice());
//			i.setProductId(getDeocodedUrl(i).getProductId());
//		});
//		cart.setTotalPrice(cartTotal(cart));
//		return cart;
//	}
//
//	private Items getPriceOfItem(Items item) {
//		item.setProductId(getDeocodedUrl(item).getProductId());
//		item.setPrice(getDeocodedUrl(item).getPrice());
//		item.setImage(getDeocodedUrl(item).getImage());
//		return item;
//	}
//
//	private ProductDetail getDeocodedUrl(Items item) {
//		String decodedUrl = "";
//		try {
//			decodedUrl = URLDecoder.decode("http://product-service/product/getProduct/name/" + item.getProductName(),
//					"UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			System.out.println("URL DECODING FAILED");
//			e.printStackTrace();
//		}
//		return this.restTemplate.getForObject(decodedUrl, ProductDetail.class);
//	}

}
