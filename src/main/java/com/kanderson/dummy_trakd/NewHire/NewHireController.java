package com.kanderson.dummy_trakd.NewHire;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/newhire")
public class NewHireController {
	
	private final NewHireService nhService;
	
	public NewHireController(NewHireService nhService) {
		this.nhService = nhService;
	}
	
	
	@GetMapping("/all")
	public List<NewHire> getNewHires() {
		return nhService.getAllNewHires();
//		List<NewHire> newhires = nhService.getAllNewHires();
//		model.addAttribute("newhires", newhires);
//		return "newhires";
//		
	}
	
//	@RequestMapping(path = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("/create")
	public void createNewHireProfile(@RequestBody NewHire newhire) {
		nhService.createNewHire(newhire);
	}
	
//	@PostMapping("/create")
//	public void createNewHireProfile(@RequestBody Map<String, String> newhire) {
//		nhService.createNewHire(newhire);
		
		
		
	//}
	
	
//	
//	@GetMapping("/{id}")
//	public NewHire getNewHire(@PathVariable Long nhId, Model model) {
//		NewHire newhire = nhService.getNewHireById(nhId);
//		model.addAttribute("newhire", newhire);
//		return "newhire";	
//		
//	}
//	
//	@PostMapping("/{id}/update-manager/{managerId")
//	public void addManager(@PathVariable Long nhId, @PathVariable Long managerId) {
//		 nhService.addManager(nhId, managerId);
//		
//	}
	
	
	

}
