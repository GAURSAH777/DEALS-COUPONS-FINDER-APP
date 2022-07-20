package com.customer.service;

import java.util.List;

import com.customer.model.Customer;

public interface CustomerService {

	Customer addCustomer(Customer customer);

	Customer customerLogin(String username, String password);

	List<Customer> getAllCustomers();

	Customer getCustomerById(String customerId);

	Customer updateCustomer(Customer customer, String customerId);

	void deleteCustomer(String customerId);

}
