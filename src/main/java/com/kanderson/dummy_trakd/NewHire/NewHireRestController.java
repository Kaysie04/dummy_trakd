package com.kanderson.dummy_trakd.NewHire;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/newhire")
public class NewHireRestController {
	
	private final NewHireService nhService;
	
	public NewHireRestController(NewHireService nhService) {
		this.nhService = nhService;
	}
	

	@GetMapping("/all")
	public List<NewHire> getNewHires() {
		return nhService.getAllNewHires();
	}


	@PostMapping("/create")
	public void createNewHireProfile(@RequestBody NewHire newhire) {
		nhService.createNewHire(newhire);
		
	}
	
	@PutMapping("/{nhId}/add-address/{addressId}")
	  public void NewHireAddAddress(@PathVariable Long nhId, @PathVariable Long addressId) {
	      nhService.addAddress(nhId, addressId);
	      System.out.println("added address");

	  }

	 @PutMapping("/{nhId}/add-dept/{deptId}")
	  public void NewHireAddDept(@PathVariable Long nhId, @PathVariable Long deptId) {
	      nhService.addDept(nhId, deptId);
	      System.out.println("added dept");

	  }

	 @PutMapping("/{nhId}/add-manager/{managerId}")
	  public void NewHireAddManager(@PathVariable Long nhId, @PathVariable Long managerId) {
	      nhService.addManager(nhId, managerId);
	      System.out.println("added manager");

	  }

}
