package com.coupon.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.coupon.model.Coupon;

@Repository
public interface CouponRepository extends MongoRepository<Coupon, String> {

}
