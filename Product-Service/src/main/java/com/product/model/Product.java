package com.product.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * used Bean Validation in Model class 
 */

@Document(collection = "product")
public class Product {

	@Id
	private String productId;

	@NotNull(message = "Product name should not be empty")
	private String productName;

	@NotNull(message = "Product price can not be null")
	private String price;

	private String rating;

	public Product() {

	}

	public Product(String productId, @NotNull(message = "Product name should not be empty") String productName,
			@NotNull(message = "Product price can not be null") String price, String rating) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.rating = rating;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", rating="
				+ rating + "]";
	}

}
