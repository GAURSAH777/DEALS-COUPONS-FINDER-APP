package com.jwt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jwt.model.CustomerUser;

@Repository
public interface CustomerUserRepository extends MongoRepository<CustomerUser, String> {

	CustomerUser findByUsername(String username);

}
