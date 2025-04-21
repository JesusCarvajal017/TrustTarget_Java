package com.trustTarget.trustTarget.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trustTarget.trustTarget.model.City;
import com.trustTarget.trustTarget.service.CityServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("api/v1/city")
public class CityController {
    @Autowired
    private CityServices CityServices;

    @GetMapping("")
    public ResponseEntity<Object> getAllCites(){
        var ListCities = CityServices.getAll();
        return new ResponseEntity<Object>(ListCities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getByIdCity(@PathVariable int id) {
        var city = CityServices.getById(id);
        return new ResponseEntity<Object>(city, HttpStatus.OK);
    }

    @PostMapping("/")
    public Object createCity(@RequestBody City city) {
        return CityServices.createEntity(city);
    }

    @PutMapping("/")
    public Object putMethodName(@RequestBody City city) {
        var response = CityServices.updateEntity(city);
        return response;
    }

    
    @DeleteMapping("/{id}")
    public Object deleteCity(@PathVariable int id){
        var response = CityServices.deleteEntity(id);
        return response;
    } 
    

}
