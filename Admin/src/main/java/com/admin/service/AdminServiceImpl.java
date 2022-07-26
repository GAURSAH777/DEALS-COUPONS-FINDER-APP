package com.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.model.Admin;

import com.admin.repositories.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	private Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Override
	public Admin addAdmin(Admin admin) {
		LOGGER.info("Add Admin -START!");
		LOGGER.info("Add Admin -END!");
		return adminRepository.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		LOGGER.info("Update Admin -START!");
		LOGGER.info("Update Admin -END!");
		return adminRepository.save(admin);
	}

	@Override
	public void deleteAdmin(int id) {
		LOGGER.info("Delete Admin -START!");
		LOGGER.info("Delete Admin -END!");
		adminRepository.deleteById(id);

	}

	@Override
	public List<Admin> getAllAdmin() {
		LOGGER.info("Fetch Admin -START!");
		LOGGER.info("Fetch Admin -END!");
		return adminRepository.findAll();
	}

}
