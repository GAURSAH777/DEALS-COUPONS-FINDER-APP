package com.coupon.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coupon.exception.CouponNotFoundException;
import com.coupon.model.Coupon;
import com.coupon.repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponRepository couponRepository;

	private Logger LOGGER = LoggerFactory.getLogger(CouponServiceImpl.class);

	@Override
	public Coupon addCoupon(Coupon coupon) {
		LOGGER.info("Add Coupon -START!");
		Coupon savedCoupon = couponRepository.save(coupon);
		LOGGER.info("Coupon added Successfully!!");
		LOGGER.info("Add Coupon -End!");
		return savedCoupon;
	}

	@Override
	public List<Coupon> getAllCoupons() {
		LOGGER.info("Get Coupon -START!");
		List<Coupon> coupons = couponRepository.findAll();
		LOGGER.info("Displaying Coupon!");
		LOGGER.info("Get Coupon -End!");
		return coupons;
	}

	@Override
	public Coupon getCouponById(String couponId) {
		LOGGER.info("Get Coupon -START!");
		Optional<Coupon> optionalCoupon = couponRepository.findById(couponId);
		if (optionalCoupon.isEmpty()) {
			LOGGER.info("Coupon Not Found!");
			throw new CouponNotFoundException("Coupon Not found with id : " + couponId);
		} else {

			Coupon coupon = optionalCoupon.get();
			LOGGER.info("Displaying Coupon!");
			LOGGER.info("Get Coupon -End!");
			return coupon;
		}
	}

	@Override
	public Coupon updateCoupon(Coupon coupon) {
		LOGGER.info("Update Coupon -START!");
		Optional<Coupon> optionalCoupon = couponRepository.findById(coupon.getCouponId());

		if (optionalCoupon == null) {
			LOGGER.info("Coupon Not Found");
			throw new CouponNotFoundException("Coupon not exising with id: " + coupon.getCouponId());
		}

		Coupon updatedCoupon = couponRepository.save(coupon);
		LOGGER.info("Coupon updated Successfully!");
		LOGGER.info("Update Coupon -End!");
		return updatedCoupon;
	}

	@Override
	public void deleteCoupon(String couponId) {
		LOGGER.info("Delete Coupon -START!");
		Optional<Coupon> optionalCoupon = couponRepository.findById(couponId);

		if (optionalCoupon == null) {
			LOGGER.info("Coupon Not Found");
			throw new CouponNotFoundException("Customer not exising with id: " + couponId);
		}

		Coupon coupon = optionalCoupon.get();
		LOGGER.info("Coupon deleted Successfully!");
		LOGGER.info("Delete Coupon -End!");
		couponRepository.delete(coupon);

	}

}
