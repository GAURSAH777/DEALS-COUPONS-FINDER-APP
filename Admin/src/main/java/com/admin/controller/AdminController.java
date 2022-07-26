package com.admin.controller;

import java.util.Arrays;
import java.util.List;

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

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "/all")
	public List<Admin> getAllAdmins() {
		return adminService.getAllAdmin();
	}

	@PostMapping("/add")
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminService.addAdmin(admin);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteAdmin(@PathVariable int id) {
		adminService.deleteAdmin(id);
	}

//	----------------Customer Service--------------------

	@GetMapping("/listUser")
	public List<Customer> fetchAllCustomers() {
		return Arrays.asList(restTemplate.getForObject("http://Customer-Service/customer/listUser", Customer[].class));
	}

//	----------------Coupon Service------------------------

	@GetMapping("/list")
	public List<Coupon> getAllCoupons() {
		return Arrays.asList(restTemplate.getForObject("http://Coupon-Service/coupon/list", Coupon[].class));
	}

	@PostMapping(value = "/addCoupon")
	public String addCoupon(@RequestBody Coupon coupon) {
		return restTemplate.postForObject("http://coupon-service/coupon/add", coupon, String.class);
	}

	@DeleteMapping(value = "/delete/{couponId}")
	public String deleteCoupon(@PathVariable String couponId) {
		restTemplate.delete("http://coupon-service/coupons/delete/{couponId}", couponId, String.class);
		return "Coupon with Id = " + couponId + " Deleted Successfully";
	}

	@PutMapping(value = "/updateCoupon/{couponId}")
	public String updateCoupon(@RequestBody Coupon coupon, @PathVariable String couponId) {
		restTemplate.put("http://coupon-service/coupons/update/{couponId}", coupon, couponId, String.class);
		return "coupon Updated Succesfully";
	}

}
