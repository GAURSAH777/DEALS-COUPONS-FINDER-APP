package com.cart.service;

import java.util.List;

import com.cart.model.Payment;

public interface PaymentService {

	public List<Payment> getAllPayments();

	public Payment savePayment(Payment payment);

	public Payment getPaymentById(String transactionId);

}
