package com.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.exception.AuthenticationFailureException;
import com.customer.exception.CustomerNotFoundException;
import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer customerLogin(String username, String password) {
		Customer customer = customerRepository.findByUsernameAndPassword(username, password);

		if (customer == null) {
			throw new AuthenticationFailureException("Username or password is incorrect");
		}

		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(String customerId) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

		if (optionalCustomer == null) {
			throw new CustomerNotFoundException("Customer not exising with id: " + customerId);
		}

		Customer customer = optionalCustomer.get();

		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCustomerId());

		if (optionalCustomer == null) {
			throw new CustomerNotFoundException("Customer not exising with id: " + customer.getCustomerId());
		}

		Customer updatedCustomer = customerRepository.save(customer);

		return updatedCustomer;
	}

	@Override
	public void deleteCustomer(String customerId) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

		if (optionalCustomer == null) {
			throw new CustomerNotFoundException("Customer not exising with id: " + customerId);
		}

		Customer customer = optionalCustomer.get();

		customerRepository.delete(customer);

	}

}
