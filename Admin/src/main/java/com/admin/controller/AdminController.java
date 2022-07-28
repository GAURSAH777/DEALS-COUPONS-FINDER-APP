package com.admin.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.admin.model.Admin;
import com.admin.model.Coupon;
import com.admin.model.Customer;
import com.admin.service.AdminService;

/*
 * @Author: Gaurab Sah
 * Created on:2022-07-26
 */

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	private Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "/all")
	public List<Admin> getAllAdmins() {
		LOGGER.info("Inside getAllAdmins of AdminController");
		return adminService.getAllAdmin();
	}

	@PostMapping("/add")
	public Admin addAdmin(@RequestBody Admin admin) {
		LOGGER.info("Inside addAdmin of AdminController");
		return adminService.addAdmin(admin);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteAdmin(@PathVariable String id) {
		LOGGER.info("Inside deleteAdmin of AdminController");
		adminService.deleteAdmin(id);
	}

//	----------------Customer Service--------------------

	@GetMapping("/allCustomers")
	public List<Customer> fetchAllCustomers() {
		LOGGER.info("Inside fetchAllCustomers of AdminController to view customer details");
		return Arrays
				.asList(restTemplate.getForObject("http://customer-service/customer/allCustomers", Customer[].class));
	}

//	----------------Coupon Service------------------------

	@GetMapping("/allCoupons")
	public List<Coupon> getAllCoupons() {
		LOGGER.info("Inside getAllCoupons of AdminController to view coupon details");
		return Arrays.asList(restTemplate.getForObject("http://coupon-service/coupon/allCoupons", Coupon[].class));
	}

	@PostMapping(value = "/save")
	public String addCoupon(@RequestBody Coupon coupon) {
		LOGGER.info("Inside addCoupon of AdminController to save coupon details");
		return restTemplate.postForObject("http://coupon-service/coupon/save", coupon, String.class);
	}

	@DeleteMapping(value = "/delete/{couponId}")
	public String deleteCoupon(@PathVariable String couponId) {
		LOGGER.info("Inside deleteCoupon of AdminController to delete coupon details");
		restTemplate.delete("http://coupon-service/coupons/delete/{couponId}", couponId, String.class);
		return "Coupon with Id = " + couponId + " Deleted Successfully";
	}

	@PutMapping(value = "/updateCoupon")
	public String updateCoupon(@RequestBody Coupon coupon) {
		LOGGER.info("Inside updateCoupon of AdminController to update coupon details");
		restTemplate.put("http://coupon-service/coupons/update/{couponId}", coupon, String.class);
		return "coupon Updated Succesfully";
	}

}
