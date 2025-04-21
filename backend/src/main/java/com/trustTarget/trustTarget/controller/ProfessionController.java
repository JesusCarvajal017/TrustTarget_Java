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

import com.trustTarget.trustTarget.model.Profession;
import com.trustTarget.trustTarget.service.ProfessionService;

@RestController
@RequestMapping("api/v1/profession")
public class ProfessionController {
    @Autowired
    private ProfessionService professionService;

    @GetMapping("")
    public ResponseEntity<Object> getAllApi(){
        var listQuery = professionService.getAll();
        return new ResponseEntity<Object>(listQuery, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getByIdApi(@PathVariable int id) {
        var query = professionService.getById(id);
        return new ResponseEntity<Object>(query, HttpStatus.OK);
    }

    @PostMapping("/")
    public Object createApi(@RequestBody Profession entity) {
        return professionService.createEntity(entity);
    }

    @PutMapping("/")
    public Object updateApi(@RequestBody Profession entity) {
        var response = professionService.updateEntity(entity);
        return response;
    }
    
    @DeleteMapping("/{id}")
    public Object deleteApi(@PathVariable int id){
        var response = professionService.deleteEntity(id);
        return response;
    } 
}
