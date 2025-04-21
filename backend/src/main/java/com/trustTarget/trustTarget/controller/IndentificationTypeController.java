package com.trustTarget.trustTarget.controller;

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

import com.trustTarget.trustTarget.model.IdentificationType;
import com.trustTarget.trustTarget.service.IdentificationTypeService;

@RestController
@RequestMapping("api/v1/identificationType")
public class IndentificationTypeController {

    private IdentificationTypeService identificationTypeService;

    public IndentificationTypeController(IdentificationTypeService identificationTypeService) {
        this.identificationTypeService = identificationTypeService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllCites(){
        var listIdentifications = identificationTypeService.getAll();
        return new ResponseEntity<Object>(listIdentifications, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getByIdCity(@PathVariable int id) {
        var identification = identificationTypeService.getById(id);
        return new ResponseEntity<Object>(identification, HttpStatus.OK);
    }

    @PostMapping("/")
    public Object createCity(@RequestBody IdentificationType identification) {
        return identificationTypeService.createEntity(identification);
    }

    @PutMapping("/")
    public Object putMethodName(@RequestBody IdentificationType identification) {
        var response = identificationTypeService.updateEntity(identification);
        return response;
    }
    
    @DeleteMapping("/{id}")
    public Object deleteCity(@PathVariable int id){
        var response = identificationTypeService.deleteEntity(id);
        return response;
    } 

}
