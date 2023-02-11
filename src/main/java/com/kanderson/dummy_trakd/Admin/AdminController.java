package com.kanderson.dummy_trakd.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AdminController {
	
	private final AdminService adminService;
	
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}


	/*
	Render the general homepage
	 */
	@RequestMapping("/homepage")
	public String renderHomepage(){
		return "homepage";
	}

	/*
	Render the create-account page
	 */
	@RequestMapping("/create-account")
	public String renderCreateAccount(){
		return "create-account";
	}

	/*
	Render the login page
	 */

	@RequestMapping("/login")
	public String renderLogin(){
		return "login";
	}

	/*
	Render the admin-home page
	 */
	@RequestMapping("/user-home")
	public String renderUserHome(){
		return "user-home";
	}

	@PostMapping("admin/create-account")
	public void createAdminAcct(@RequestBody Admin admin) {
		 adminService.createAdmin(admin);
	}
	
	@PutMapping("admin/{adminId}")
	public void updateAdminAcct
			(@PathVariable("adminId") Long adminId,
			@RequestBody String password) {

		adminService.updateAdmin(adminId, password);
	}
	
}