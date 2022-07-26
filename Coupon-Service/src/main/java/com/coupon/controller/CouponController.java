package com.coupon.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coupon.model.Coupon;
import com.coupon.service.CouponService;

/*
 * @Author: Gaurab Sah
 * Created on:2022-07-222
 */

@RestController
@RequestMapping("/coupon")
public class CouponController {

	@Autowired
	private CouponService couponService;

	private Logger LOGGER = LoggerFactory.getLogger(CouponController.class);

	/*
	 * fetchAllCoupons() is used to get all the list of coupons
	 */

	@GetMapping("/allCoupons")
	public List<Coupon> fetchAllCoupons() {
		LOGGER.info("Inside fetchAllCoupons of CouponController");

		List<Coupon> coupons = couponService.getAllCoupons();
		LOGGER.info("Fetching  Coupons");
		LOGGER.info("Fetching  Coupon -END!");
		return coupons;
	}

	/*
	 * addCoupon() is used to add coupon details
	 */

	@PostMapping("/save")
	public ResponseEntity<Coupon> addCoupon(@Valid @RequestBody Coupon coupon) {
		LOGGER.info("Inside addCoupon of CouponController");
		Coupon newCoupon = couponService.addCoupon(coupon);
		ResponseEntity<Coupon> responseEntity = new ResponseEntity<>(newCoupon, HttpStatus.CREATED);
		LOGGER.info("adding  Coupons");
		LOGGER.info("Adding  Coupon -END!");
		return responseEntity;
	}

	/*
	 * fetchCouponById() is used to get the detail of particular coupon
	 */

	@GetMapping("/get/{id}")
	public ResponseEntity<?> fetchCouponById(@PathVariable("id") String couponId) {
		LOGGER.info("Inside fetchCouponById of CouponController");
		ResponseEntity<?> responseEntity = null;
		Coupon coupon = couponService.getCouponById(couponId);
		responseEntity = new ResponseEntity<>(coupon, HttpStatus.OK);
		LOGGER.info("Fetching  Coupons");
		LOGGER.info("Fetching  Coupon -END!");
		return responseEntity;
	}

	/*
	 * deleteCouponById() is used to delete/remove a particular coupon
	 */

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCouponById(@PathVariable("id") String couponId) {
		LOGGER.info("Inside deleteCouponById of CouponController");
		ResponseEntity<String> responseEntity = null;
		couponService.deleteCoupon(couponId);
		responseEntity = new ResponseEntity<>("Coupon deleted successfully", HttpStatus.OK);
		LOGGER.info("Deleting  Coupons");
		LOGGER.info("Deleting  Coupon -END!");
		return responseEntity;
	}

	/*
	 * updateCoupon() is used to update a particular coupon detail
	 */

	@PutMapping("/update")
	public ResponseEntity<Object> updateCoupon(@Valid @RequestBody Coupon coupon) {
		LOGGER.info("Inside updateCoupon of CouponController");
		ResponseEntity<Object> responseEntity = null;
		couponService.updateCoupon(coupon);
		responseEntity = new ResponseEntity<>("Coupon updated successfully", HttpStatus.OK);
		LOGGER.info("Updating  Coupons");
		LOGGER.info("Updating  Coupon -END!");
		return responseEntity;
	}

}
