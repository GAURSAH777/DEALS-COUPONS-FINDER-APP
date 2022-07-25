package com.payment.controller;

import java.util.List;

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

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/save")
	public ResponseEntity<PaymentDetails> addPayment(@RequestBody PaymentDetails payment) {
		PaymentDetails savedPayment = paymentService.addPayment(payment);
		ResponseEntity<PaymentDetails> responseEntity = new ResponseEntity<PaymentDetails>(savedPayment,
				HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<PaymentDetails>> fetchAllPayment() {
		List<PaymentDetails> allPayment = paymentService.viewAllPaymentDetails();
		ResponseEntity<List<PaymentDetails>> responseEntity = new ResponseEntity<List<PaymentDetails>>(allPayment,
				HttpStatus.ACCEPTED);
		return responseEntity;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<PaymentDetails> fetchPaymentDetailById(@PathVariable("id") String paymentId) {
		PaymentDetails pay = paymentService.viewPaymentDetailById(paymentId);
		ResponseEntity<PaymentDetails> responseEntity = new ResponseEntity<PaymentDetails>(pay, HttpStatus.ACCEPTED);
		return responseEntity;
	}

}
