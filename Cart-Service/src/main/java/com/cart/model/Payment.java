package com.cart.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payment")
public class Payment {

	@Id
	private String transactionId;

	@NotNull(message = "Card number should not be empty")
	@Pattern(regexp = "^4[0-9]{12}(?:[0-9]{3})?$", message = " string should be starts with 4")
	private String cardNumber;

	private String cardHolderName;

	@NotNull(message = "Card type should not be empty")
	private String cardType;

	@NotNull(message = "Bank name should not be empty")
	private String bankName;

	@NotNull(message = "Amount should not be empty")
	private double amount;

	private String description;

	@NotNull(message = "Payment Date should not be empty")
	private String paymentDate;

	@NotNull(message = "Customer Id should not be empty")
	private String customerId;

	@NotNull(message = "Product name should not be empty")
	private String couponId;

	public Payment() {

	}

	public Payment(String transactionId,
			@NotNull(message = "Card number should not be empty") @Pattern(regexp = "^4[0-9]{12}(?:[0-9]{3})?$", message = " string should be starts with 4") String cardNumber,
			String cardHolderName, @NotNull(message = "Card type should not be empty") String cardType,
			@NotNull(message = "Bank name should not be empty") String bankName,
			@NotNull(message = "Amount should not be empty") double amount, String description,
			@NotNull(message = "Payment Date should not be empty") String paymentDate,
			@NotNull(message = "Customer Id should not be empty") String customerId,
			@NotNull(message = "Product name should not be empty") String couponId) {
		super();
		this.transactionId = transactionId;
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.cardType = cardType;
		this.bankName = bankName;
		this.amount = amount;
		this.description = description;
		this.paymentDate = paymentDate;
		this.customerId = customerId;
		this.couponId = couponId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	@Override
	public String toString() {
		return "Payment [transactionId=" + transactionId + ", cardNumber=" + cardNumber + ", cardHolderName="
				+ cardHolderName + ", cardType=" + cardType + ", bankName=" + bankName + ", amount=" + amount
				+ ", description=" + description + ", paymentDate=" + paymentDate + ", customerId=" + customerId
				+ ", couponId=" + couponId + "]";
	}

}
