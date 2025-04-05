package com.trustTarget.trustTarget.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trustTarget.trustTarget.service.CityServices;

@Controller
@RequestMapping("api/v1/city")
public class CityController {
    private CityServices CityServices;

    @GetMapping("/")
    public ResponseEntity<Object> getAllCites(){
        var ListCities = CityServices.getAllCities();
        return new ResponseEntity<Object>(ListCities, HttpStatus.OK);
    }
}
