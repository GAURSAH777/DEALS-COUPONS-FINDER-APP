package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.model.Admin;
import com.admin.model.Coupon;
import com.admin.model.Customer;
import com.admin.model.Product;
import com.admin.repositories.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public void deleteAdmin(int id) {
		adminRepository.deleteById(id);

	}

	@Override
	public List<Admin> getAllAdmin() {
		return adminRepository.findAll();
	}

	@Override
	public List<Customer> getAllCustomers() {
		return null;
	}

	@Override
	public List<Coupon> getAllCoupons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coupon addCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coupon updateCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCoupon(String couponId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(String productId) {
		// TODO Auto-generated method stub
		
	}

}
