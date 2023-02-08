package com.kanderson.dummy_trakd.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private final AdminService adminService;
	
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}

	@PostMapping("/create-account")
	public void createAdminAcct(@RequestBody Admin admin) {
		 adminService.createAdmin(admin);
	}
	
	@PutMapping("/{adminId}")
	public void updateAdminAcct
			(@PathVariable("adminId") Long adminId,
			@RequestBody String password) {
		
		adminService.updateAdmin(adminId, password);
	}
	
}