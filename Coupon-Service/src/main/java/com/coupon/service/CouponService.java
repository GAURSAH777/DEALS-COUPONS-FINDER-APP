package com.coupon.service;

import java.util.List;
import java.util.Optional;

import com.coupon.model.Coupon;

public interface CouponService {

	Coupon addCoupon(Coupon coupon);

	List<Coupon> getAllCoupons();

	Optional<Coupon> getCouponById(String couponId);

	Coupon updateCoupon(Coupon coupon);

	void deleteCoupon(String couponId);

}
