package com.coupon.controller;

import java.util.List;

import javax.validation.Valid;

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

@RestController
@RequestMapping("/coupon")
public class CouponController {

	@Autowired
	private CouponService couponService;

	@GetMapping("/allCustomers")
	public List<Coupon> fetchAllCoupons() {

		List<Coupon> coupons = couponService.getAllCoupons();
		return coupons;
	}

	@PostMapping("/save")
	public ResponseEntity<Coupon> addCoupon(@Valid @RequestBody Coupon coupon) {

		Coupon newCoupon = couponService.addCoupon(coupon);
		ResponseEntity<Coupon> responseEntity = new ResponseEntity<>(newCoupon, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> fetchCouponById(@PathVariable("id") String couponId) {

		ResponseEntity<?> responseEntity = null;
		Coupon coupon = couponService.getCouponById(couponId);
		responseEntity = new ResponseEntity<>(coupon, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCouponById(@PathVariable("id") String couponId) {

		ResponseEntity<String> responseEntity = null;
		couponService.deleteCoupon(couponId);
		responseEntity = new ResponseEntity<>("Coupon deleted successfully", HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping("/update")
	public ResponseEntity<Object> updateCustomer(@Valid @RequestBody Coupon coupon) {

		ResponseEntity<Object> responseEntity = null;
		couponService.updateCoupon(coupon);
		responseEntity = new ResponseEntity<>("Coupon updated successfully", HttpStatus.OK);
		return responseEntity;
	}

}
