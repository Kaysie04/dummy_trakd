package com.kanderson.dummy_trakd.NewHire;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class NewHireController {
   private final NewHireService nhService;

    public NewHireController(NewHireService nhService) {
        this.nhService = nhService;
    }


    /*
      Render the create newhire form
      when you click submit it should hit the /api/create route in NewHireRestController
    */
    @RequestMapping("/create-newhire")
    public String renderCreateNewhire(){
        return "create-newhire";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
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


