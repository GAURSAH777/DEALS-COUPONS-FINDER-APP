package com.customer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.model.Customer;
import com.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/customer-login")
	public ResponseEntity<Customer> doCustomerLogin(@RequestParam("username") String username,
			@RequestParam("password") final String password) {

		Customer customer = customerService.customerLogin(username, password);

		ResponseEntity<Customer> responseEntity = new ResponseEntity<>(customer, HttpStatus.OK);

		return responseEntity;

	}

	@GetMapping("/allCustomers")
	public List<Customer> fetchAllCustomers() {

		List<Customer> customers = customerService.getAllCustomers();
		return customers;
	}

	@PostMapping("/save")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) {

		Customer newCustomer = customerService.addCustomer(customer);
		ResponseEntity<Customer> responseEntity = new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> fetchCustomerById(@PathVariable("id") String customerId) {

		ResponseEntity<?> responseEntity = null;
		Customer customer = customerService.getCustomerById(customerId);
		responseEntity = new ResponseEntity<>(customer, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable("id") String customerId) {

		ResponseEntity<String> responseEntity = null;
		customerService.deleteCustomer(customerId);
		responseEntity = new ResponseEntity<>("Customer deleted successfully", HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping("/update")
	public ResponseEntity<Object> updateCustomer(@Valid @RequestBody Customer customer) {

		ResponseEntity<Object> responseEntity = null;
		customerService.updateCustomer(customer);
		responseEntity = new ResponseEntity<>("Customer updated successfully", HttpStatus.OK);
		return responseEntity;
	}

}
