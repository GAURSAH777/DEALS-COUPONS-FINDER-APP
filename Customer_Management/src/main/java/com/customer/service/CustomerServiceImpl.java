package com.customer.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Override
	public Customer addCustomer(Customer customer) {
		LOGGER.info("Add Customer (Service) - START");
		Customer addedCustomer = customerRepository.save(customer);
		LOGGER.info("Customer Added Successfully!");
		LOGGER.info("Add Customer (Service) - END");
		return addedCustomer;

	}

	@Override
	public Customer customerLogin(String username, String password) {
		LOGGER.info("Customer login - START");
		Customer customer = customerRepository.findByUsernameAndPassword(username, password);

		if (customer == null) {
			throw new AuthenticationFailureException("Username or password is incorrect");
		}

		LOGGER.info("Customer logged in successfully - START");

		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		LOGGER.info("View All Customers (Service) -START!");

		List<Customer> list = customerRepository.findAll();

		LOGGER.info("Displaying Customers!");
		LOGGER.info("View All Customers  (Service) -END!");

		return list;
	}

	@Override
	public Customer getCustomerById(String customerId) {
		LOGGER.info("View Customer (Service) -START!");
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

		if (optionalCustomer == null) {
			LOGGER.error("Customer cannot be Found!");
			throw new CustomerNotFoundException("Customer not exising with id: " + customerId);
		}

		Customer customer = optionalCustomer.get();

		LOGGER.info("Displaying Customer!");
		LOGGER.info("View Customer  (Service) -END!");

		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		LOGGER.info("Update Customer (Service) -START!");
		Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCustomerId());

		if (optionalCustomer == null) {
			LOGGER.error("Customer cannot be Found!");
			throw new CustomerNotFoundException("Customer not exising with id: " + customer.getCustomerId());
		}

		Customer updatedCustomer = customerRepository.save(customer);
		LOGGER.info("Update Customer  (Service) -END!");

		return updatedCustomer;
	}

	@Override
	public void deleteCustomer(String customerId) {
		LOGGER.info("Delete Customer  (Service) -START!");
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

		if (optionalCustomer == null) {
			LOGGER.error("Customer cannot be Found!");
			throw new CustomerNotFoundException("Customer not exising with id: " + customerId);
		}

		Customer customer = optionalCustomer.get();
		LOGGER.info("Customer deleted Successfully!!");
		LOGGER.info("Delete Customer  (Service) -END!");
		customerRepository.delete(customer);

	}

}
