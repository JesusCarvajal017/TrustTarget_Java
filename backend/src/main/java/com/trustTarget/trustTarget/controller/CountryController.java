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

import com.trustTarget.trustTarget.model.Country;
import com.trustTarget.trustTarget.service.CountryService;

@RestController
@RequestMapping("api/v1/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("")
    public ResponseEntity<Object> getAllApi(){
        var listQuery = countryService.getAll();
        return new ResponseEntity<Object>(listQuery, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getByIdApi(@PathVariable int id) {
        var query = countryService.getById(id);
        return new ResponseEntity<Object>(query, HttpStatus.OK);
    }

    @PostMapping("/")
    public Object createApi(@RequestBody Country entity) {
        return countryService.createEntity(entity);
    }

    @PutMapping("/")
    public Object updateApi(@RequestBody Country entity) {
        var response = countryService.updateEntity(entity);
        return response;
    }
    
    @DeleteMapping("/{id}")
    public Object deleteApi(@PathVariable int id){
        var response = countryService.deleteEntity(id);
        return response;
    } 

}
