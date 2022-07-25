package com.payment.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.exception.PaymentNotFoundException;
import com.payment.model.PaymentDetails;
import com.payment.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public PaymentDetails addPayment(PaymentDetails payment) {
		payment.setPaymentStatus(paystatus());
		payment.setPaymentId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
	}

	private String paystatus() {
		return new Random().nextBoolean() ? "success" : "failure";
	}

	@Override
	public List<PaymentDetails> viewAllPaymentDetails() {
		List<PaymentDetails> pay = paymentRepository.findAll();
		if (pay == null) {
			throw new PaymentNotFoundException();
		} else
			return pay;
	}

	@Override
	public PaymentDetails viewPaymentDetailById(String paymentId) {
		Optional<PaymentDetails> payment = paymentRepository.findById(paymentId);
		if (payment == null) {
			throw new PaymentNotFoundException();
		} else {
			PaymentDetails list = payment.get();
			return list;
		}

	}

}
