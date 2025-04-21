package com.trustTarget.trustTarget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trustTarget.trustTarget.model.Company;
import com.trustTarget.trustTarget.service.CompanyService;

@RestController
@RequestMapping("api/v1/company")
public class CompanyController {

    @Autowired
    private CompanyService companyServices;

    @GetMapping("")
    public ResponseEntity<Object> getAllCompany(){
        var ListCities = companyServices.getAll();
        return new ResponseEntity<Object>(ListCities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getByIdCity(@PathVariable int id) {
        var city = companyServices.getById(id);
        return new ResponseEntity<Object>(city, HttpStatus.OK);
    }

    @PostMapping("/")
    public Object createCity(@RequestBody Company company) {
        return companyServices.createEntity(company);
    }

    @PutMapping("/")
    public Object putMethodName(@RequestBody Company company) {
        var response = companyServices.updateEntity(company);
        return response;
    }

    
    @DeleteMapping("/{id}")
    public Object deleteCity(@PathVariable int id){
        var response = companyServices.deleteEntity(id);
        return response;
    } 
}
