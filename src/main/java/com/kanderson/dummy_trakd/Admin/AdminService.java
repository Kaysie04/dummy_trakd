package com.kanderson.dummy_trakd.Admin;


import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class AdminService {
	
	private final AdminRepository adminRepository;
	
	@Autowired
	public AdminService(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	
	public void createAdmin(Admin admin) {
		 adminRepository.save(admin);
	}
	
	
	@Transactional
	public void updateAdmin(Long adminId, String password) {
		Optional <Admin> oldAdminOptional = adminRepository.findById(adminId);	 
		if(oldAdminOptional.isPresent()) {
			
			Admin newAdmin = oldAdminOptional.get();
			newAdmin.setPassword(password);
			adminRepository.save(newAdmin);	
		}
		else throw new IllegalStateException("account not found with id: " + adminId);
			
		
	}
}
