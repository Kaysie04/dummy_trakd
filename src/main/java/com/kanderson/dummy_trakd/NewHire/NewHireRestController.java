package com.kanderson.dummy_trakd.NewHire;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NewHireRestController {
	
	private final NewHireService nhService;
	
	public NewHireRestController(NewHireService nhService) {
		this.nhService = nhService;
	}
	

//	@GetMapping("/all")
//	public List<NewHire> getNewHires() {
//		return nhService.getAllNewHires();
//	}



	/*
	Create newhire first form information.
	 Retrieves JSON body and saves to database
	 */
//	@PostMapping("/create-newhire")
//	public void createNewHireProfile(@RequestBody NewHire newhire) {
//		nhService.createNewHire(newhire);
//	}
//
//	@PutMapping("/add-dept")
//	@ResponseBody
//	public String addDept(@RequestParam("nhId") Long nhId, @RequestParam("deptId") Long deptId, Model newhire, Model dept) {
//		newhire.addAttribute("nhId", nhId);
//		dept.addAttribute("deptId", deptId);
//		nhService.addDept(nhId, deptId);
//		return "add-manager";
//
//	}
}



	
//	@PutMapping("/{nhId}/add-address/{addressId}")
//	  public void NewHireAddAddress(@PathVariable Long nhId, @PathVariable Long addressId) {
//	      nhService.addAddress(nhId, addressId);
//	      System.out.println("added address");
//
//	  }
//
//	 @PutMapping("/{nhId}/add-dept/{deptId}")
//	  public void NewHireAddDept(@PathVariable Long nhId, @PathVariable Long deptId) {
//	      nhService.addDept(nhId, deptId);
//	      System.out.println("added dept");
//
//	  }
//
//	 @PutMapping("/{nhId}/add-manager/{managerId}")
//	  public void NewHireAddManager(@PathVariable Long nhId, @PathVariable Long managerId) {
//	      nhService.addManager(nhId, managerId);
//	      System.out.println("added manager");
//
//	  }


