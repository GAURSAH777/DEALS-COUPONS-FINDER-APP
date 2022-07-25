package com.payment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payment")
public class PaymentDetails {

	@Id
	private String paymentId;

	private String Amount;

	private String paymentStatus;

	public PaymentDetails() {

	}

	public PaymentDetails(String paymentId, String amount, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		Amount = amount;
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "PaymentDetails [paymentId=" + paymentId + ", Amount=" + Amount + ", paymentStatus=" + paymentStatus
				+ "]";
	}

}
