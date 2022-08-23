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

	private String imageUrl;

	public Product() {

	}

	public Product(String productId, @NotNull(message = "Product name should not be empty") String productName,
			@NotNull(message = "Product price can not be null") String price, String imageUrl) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.imageUrl = imageUrl;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", imageUrl="
				+ imageUrl + "]";
	}

}
