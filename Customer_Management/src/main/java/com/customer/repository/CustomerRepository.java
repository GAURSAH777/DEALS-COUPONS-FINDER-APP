package com.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.customer.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

	public Customer findByUsernameAndPassword(String username, String password);

//	public Object getOne(String id);

}
