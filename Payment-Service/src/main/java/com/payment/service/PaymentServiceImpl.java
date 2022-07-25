package com.payment.service;

import java.util.List;
import java.util.Optional;

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
		return paymentRepository.save(payment);
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
	public PaymentDetails viewPaymentDetailById(int paymentId) {
		Optional<PaymentDetails> payment = paymentRepository.findById(paymentId);
		if (payment == null) {
			throw new PaymentNotFoundException();
		} else {
			PaymentDetails list = payment.get();
			return list;
		}

	}

}
