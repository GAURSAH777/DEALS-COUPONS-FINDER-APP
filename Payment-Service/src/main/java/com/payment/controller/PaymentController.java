package com.payment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.model.PaymentDetails;
import com.payment.service.PaymentService;

/*
 * @Author: Gaurab Sah
 * Created on:2022-07-25
 */

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	private Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

	@PostMapping("/save")
	public ResponseEntity<PaymentDetails> addPayment(@RequestBody PaymentDetails payment) {
		LOGGER.info("Inside addPayment of PaymentController");
		PaymentDetails savedPayment = paymentService.addPayment(payment);
		LOGGER.info("Adding...");
		ResponseEntity<PaymentDetails> responseEntity = new ResponseEntity<PaymentDetails>(savedPayment,
				HttpStatus.CREATED);
		LOGGER.info("Payment Successfull");
		LOGGER.info("Add Payment -End!");
		return responseEntity;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<PaymentDetails>> fetchAllPayment() {
		LOGGER.info("Inside fetchAllPayments of PaymentController");
		List<PaymentDetails> allPayment = paymentService.viewAllPaymentDetails();
		ResponseEntity<List<PaymentDetails>> responseEntity = new ResponseEntity<List<PaymentDetails>>(allPayment,
				HttpStatus.ACCEPTED);
		LOGGER.info("Fetch Payment -End!");
		return responseEntity;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<PaymentDetails> fetchPaymentDetailById(@PathVariable("id") String paymentId) {
		LOGGER.info("Inside fetchPayment of PaymentController");
		PaymentDetails pay = paymentService.viewPaymentDetailById(paymentId);
		ResponseEntity<PaymentDetails> responseEntity = new ResponseEntity<PaymentDetails>(pay, HttpStatus.ACCEPTED);
		LOGGER.info("Fetch Payment -End!");
		return responseEntity;
	}

}
