package com.kanderson.dummy_trakd.NewHire;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/newhire")
public class NewHireController {
	
	private final NewHireService nhService;
	
	public NewHireController(NewHireService nhService) {
		this.nhService = nhService;
	}
	
	
//	@GetMapping("/all")
//	public List<NewHire> getNewHires(Model model) {
//		List<NewHire> newhires = nhService.getAllNewHires();
//		model.addAttribute("newhires", newhires);
//		return "newhires";
//		
//	}
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
