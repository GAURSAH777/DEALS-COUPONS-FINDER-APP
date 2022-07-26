package com.admin.service;

import java.util.List;

import com.admin.model.Admin;

public interface AdminService {

	Admin addAdmin(Admin admin);

	Admin updateAdmin(Admin admin);

	void deleteAdmin(int id);

	List<Admin> getAllAdmin();
}

//	--------Customer Service----------
//	List<Customer> getAllCustomers();

//	---------Coupon Service-------------

//	List<Coupon> getAllCoupons();
//
//	Coupon addCoupon(Coupon coupon);
//
//	Coupon updateCoupon(Coupon coupon);
//
//	void deleteCoupon(String couponId);

//	--------------Product Service------------
//	
//	List<Product> getAllProducts();
//
//	Product addProduct(Product product);
//
//	Product updateProduct(Product product);
//
//	void deleteProduct(String productId);
//
