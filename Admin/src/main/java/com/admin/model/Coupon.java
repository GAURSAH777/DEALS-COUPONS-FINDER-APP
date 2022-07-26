package com.admin.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * Added bean validation
 */

public class Coupon {

	@Id
	private String couponId;

	@NotNull(message = "Coupon Code can not be empty")
//	@Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z])$", message = "Coupon Code should contain at least one upper case letter and at least one digit")
	private String couponCode;

	@NotNull(message = "Company Name can not be empty")
	private String companyName;

	@NotNull(message = "Coupon category can not be empty")
	private String category;

	@NotNull(message = "Coupon details can not be empty")
	private String offerDetails;

	@NotNull(message = "Coupon Code expiry date can not be empty")
	private Date expiryDate;

	public Coupon() {

	}

	public Coupon(String couponId,
			@NotNull(message = "Coupon Code can not be empty") @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z])$", message = "Coupon Code should contain at least one upper case letter and at least one digit") String couponCode,
			@NotNull(message = "Company Name can not be empty") String companyName,
			@NotNull(message = "Coupon category can not be empty") String category,
			@NotNull(message = "Coupon details can not be empty") String offerDetails,
			@NotNull(message = "Coupon Code expiry date can not be empty") Date expiryDate) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.companyName = companyName;
		this.category = category;
		this.offerDetails = offerDetails;
		this.expiryDate = expiryDate;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", couponCode=" + couponCode + ", companyName=" + companyName
				+ ", category=" + category + ", offerDetails=" + offerDetails + ", expiryDate=" + expiryDate + "]";
	}

}
