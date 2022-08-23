package com.cart.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cart")
public class Cart {

	@Id
	private String cartId;

	private List<Product> products;

	private String totalPrice;

	public Cart() {

	}

	public Cart(String cartId, List<Product> products, String totalPrice) {
		super();
		this.cartId = cartId;
		this.products = products;
		this.totalPrice = totalPrice;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", products=" + products + ", totalPrice=" + totalPrice + "]";
	}

}
