package com.payment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.payment.model.PaymentDetails;

@Repository
public interface PaymentRepository extends MongoRepository<PaymentDetails, Integer> {

}
