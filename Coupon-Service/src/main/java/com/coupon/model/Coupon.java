package com.coupon.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * Added bean validation
 */

@Document(collection = "coupon")
public class Coupon {

	@Id
	private String couponId;

	@NotNull(message = "Coupon Code can not be empty")
//	@Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z])$", message = "Coupon Code should contain at least one upper case letter and at least one digit")
	private String couponCode;

	@NotNull(message = "Product Name can not be empty")
	private String productName;

	@NotNull(message = "Coupon category can not be empty")
	private String category;

	@NotNull(message = "Coupon details can not be empty")
	private String offerDetails;

	@NotNull(message = "Coupon Code expiry date can not be empty")
	private String expiryDate;

	private String price;

	private String imageUrl;

	public Coupon() {

	}

	public Coupon(String couponId, @NotNull(message = "Coupon Code can not be empty") String couponCode,
			@NotNull(message = "Product Name can not be empty") String productName,
			@NotNull(message = "Coupon category can not be empty") String category,
			@NotNull(message = "Coupon details can not be empty") String offerDetails,
			@NotNull(message = "Coupon Code expiry date can not be empty") String expiryDate, String price,
			String imageUrl) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.productName = productName;
		this.category = category;
		this.offerDetails = offerDetails;
		this.expiryDate = expiryDate;
		this.price = price;
		this.imageUrl = imageUrl;
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOfferDetails() {
		return offerDetails;
	}

	public void setOfferDetails(String offerDetails) {
		this.offerDetails = offerDetails;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
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
		return "Coupon [couponId=" + couponId + ", couponCode=" + couponCode + ", productName=" + productName
				+ ", category=" + category + ", offerDetails=" + offerDetails + ", expiryDate=" + expiryDate
				+ ", price=" + price + ", imageUrl=" + imageUrl + "]";
	}

}
