package com.customer.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.client.RestTemplate;

import com.customer.model.Customer;
import com.customer.service.CustomerService;

/*
 * @Author: Gaurab Sah
 * Created on:2022-07-21
 *
 * This controller class contains some basic CRUD operations
 */

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private RestTemplate restTemplate;

	private Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	/*
	 * doCustomerLogin() is used to login to the customer dashboard
	 */

	@PostMapping("/customer-login")
	public ResponseEntity<Customer> doCustomerLogin(@RequestParam("username") String username,
			@RequestParam("password") final String password) {

		LOGGER.info("customer is logging-START");

		Customer customer = customerService.customerLogin(username, password);

		ResponseEntity<Customer> responseEntity = new ResponseEntity<>(customer, HttpStatus.OK);

		LOGGER.info("customer logged in successfully-END");
		return responseEntity;

	}

	/*
	 * fetchAllCustomers() is used to get list of all customers
	 */

	@GetMapping("/allCustomers")
	public List<Customer> fetchAllCustomers() {
		LOGGER.info("Inside fetchAllCustomers of CustomerController");
		List<Customer> customers = customerService.getAllCustomers();
		return customers;
	}

	/*
	 * addCustomer() is used to add customer details
	 */

	@PostMapping("/save")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) {
		LOGGER.info("Inside addCustomers of CustomerController");
		Customer newCustomer = customerService.addCustomer(customer);
		ResponseEntity<Customer> responseEntity = new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
		return responseEntity;
	}

	/*
	 * fetchCustomerById() is used to get detail of particular customer
	 */

	@GetMapping("/get/{id}")
	public ResponseEntity<?> fetchCustomerById(@PathVariable("id") String customerId) {
		LOGGER.info("Inside fetchCustomerById of CustomerController");
		ResponseEntity<?> responseEntity = null;
		Customer customer = customerService.getCustomerById(customerId);
		responseEntity = new ResponseEntity<>(customer, HttpStatus.OK);
		return responseEntity;
	}

	/*
	 * deleteCustomerById() is used to delete a single customer detail
	 */

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable("id") String customerId) {
		LOGGER.info("Inside deleteCustomerById of CustomerController");
		ResponseEntity<String> responseEntity = null;
		customerService.deleteCustomer(customerId);
		responseEntity = new ResponseEntity<>("Customer deleted successfully", HttpStatus.OK);
		return responseEntity;
	}

	/*
	 * updateCustomer() is used to update particular customer detail
	 */

	@PutMapping("/update")
	public ResponseEntity<Object> updateCustomer(@Valid @RequestBody Customer customer) {
		LOGGER.info("Inside updateCustomer of CustomerController");
		ResponseEntity<Object> responseEntity = null;
		customerService.updateCustomer(customer);
		responseEntity = new ResponseEntity<>("Customer updated successfully", HttpStatus.OK);
		LOGGER.info("Customer updated successfully");
		return responseEntity;
	}

}
