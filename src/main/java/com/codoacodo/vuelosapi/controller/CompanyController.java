package com.codoacodo.vuelosapi.controller;

import com.codoacodo.vuelosapi.exception.ResourceNotFoundException;
import com.codoacodo.vuelosapi.models.Company;
import com.codoacodo.vuelosapi.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    CompanyService companyService;
    @CrossOrigin
    @GetMapping("")
    public List<Company> getAllCompanies(){
        return companyService.allCompanies();
    }

    @PostMapping("/add")
    public void createCompany(@RequestBody Company company){
        companyService.createCompany(company);
    }

    @GetMapping("/{id}")
    public Company findById(@PathVariable Long id){
        return companyService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCompany(@PathVariable Long id){
        try {
            companyService.deleteCompany(id);
            return "Compañia eliminada";
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return "No existe esa compañia";
        }
    }

    @PutMapping ("/update")
    public Company updateCompany (@RequestBody Company company) {
        return companyService.updateCompany(company);
    }
}
