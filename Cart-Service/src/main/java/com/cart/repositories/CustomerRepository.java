package com.cart.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cart.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

}
