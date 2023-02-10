package com.kanderson.dummy_trakd.NewHire;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/newhire")
public class NewHireController {

   private final NewHireService nhService;

    public NewHireController(NewHireService nhService) {
        this.nhService = nhService;
    }


    @GetMapping("/all")
    public String getNewHires(Model model) {
        Iterable<NewHire> data = nhService.getAllNewHires();
        model.addAttribute("data", data);
        return "getallnewhires";

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


