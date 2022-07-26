package com.payment.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.exception.PaymentNotFoundException;
import com.payment.model.PaymentDetails;
import com.payment.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	private Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);

	@Override
	public PaymentDetails addPayment(PaymentDetails payment) {
		LOGGER.info("Add Payment -START!");
		payment.setPaymentStatus(paystatus());
		payment.setPaymentId(UUID.randomUUID().toString());
		LOGGER.info("Payment Successfull!!!");
		LOGGER.info("Add Payment -END!");
		return paymentRepository.save(payment);
	}

	private String paystatus() {
		return new Random().nextBoolean() ? "success" : "failure";
	}

	@Override
	public List<PaymentDetails> viewAllPaymentDetails() {
		LOGGER.info("View Payment -START!");
		List<PaymentDetails> pay = paymentRepository.findAll();
		if (pay == null) {
			LOGGER.info("Payment Not Found");
			throw new PaymentNotFoundException();
		} else

			LOGGER.info("View Payment -End!");
		return pay;
	}

	@Override
	public PaymentDetails viewPaymentDetailById(String paymentId) {
		LOGGER.info("View Payment -START!");
		Optional<PaymentDetails> payment = paymentRepository.findById(paymentId);
		if (payment == null) {
			LOGGER.info("Payment Not Found");
			throw new PaymentNotFoundException();
		} else {
			PaymentDetails list = payment.get();
			LOGGER.info("View Payment -END!");
			return list;
		}

	}

}
