package com.payment.service;

import java.util.List;

import com.payment.model.PaymentDetails;

public interface PaymentService {

	PaymentDetails addPayment(PaymentDetails payment);

	List<PaymentDetails> viewAllPaymentDetails();

	PaymentDetails viewPaymentDetailById(int paymentId);

}
