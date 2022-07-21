package com.coupon.service;

import java.util.List;

import com.coupon.model.Coupon;

public interface CouponService {

	Coupon addCoupon(Coupon coupon);

	List<Coupon> getAllCoupons();

	Coupon getCouponById(String couponId);

	Coupon updateCoupon(Coupon coupon);

	void deleteCoupon(String couponId);

}
