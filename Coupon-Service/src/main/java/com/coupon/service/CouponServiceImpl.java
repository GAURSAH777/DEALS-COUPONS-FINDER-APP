package com.coupon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coupon.exception.CouponNotFoundException;
import com.coupon.model.Coupon;
import com.coupon.repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponRepository couponRepository;

	@Override
	public Coupon addCoupon(Coupon coupon) {
		Coupon savedCoupon = couponRepository.save(coupon);
		return savedCoupon;
	}

	@Override
	public List<Coupon> getAllCoupons() {
		List<Coupon> coupons = couponRepository.findAll();
		return coupons;
	}

	@Override
	public Coupon getCouponById(String couponId) {
		Optional<Coupon> optionalCoupon = couponRepository.findById(couponId);
		if (optionalCoupon.isEmpty())
			throw new CouponNotFoundException("Coupon Not found with id : " + couponId);
		Coupon coupon = optionalCoupon.get();
		return coupon;
	}

	@Override
	public Coupon updateCoupon(Coupon coupon) {
		Optional<Coupon> optionalCoupon = couponRepository.findById(coupon.getCouponId());

		if (optionalCoupon == null) {
			throw new CouponNotFoundException("Coupon not exising with id: " + coupon.getCouponId());
		}

		Coupon updatedCoupon = couponRepository.save(coupon);

		return updatedCoupon;
	}

	@Override
	public void deleteCoupon(String couponId) {
		Optional<Coupon> optionalCoupon = couponRepository.findById(couponId);

		if (optionalCoupon == null) {
			throw new CouponNotFoundException("Customer not exising with id: " + couponId);
		}

		Coupon coupon = optionalCoupon.get();

		couponRepository.delete(coupon);

	}

}
