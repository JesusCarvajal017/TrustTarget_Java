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

import com.trustTarget.trustTarget.model.TrustTarget;
import com.trustTarget.trustTarget.service.TrustTargetService;

@RestController
@RequestMapping("api/v1/trustTarget")
public class TrustTargetController {
    @Autowired
    private TrustTargetService trustTargetService;

    @GetMapping("")
    public ResponseEntity<Object> getAllApi(){
        var listQuery = trustTargetService.getAll();
        return new ResponseEntity<Object>(listQuery, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getByIdApi(@PathVariable int id) {
        var query = trustTargetService.getById(id);
        return new ResponseEntity<Object>(query, HttpStatus.OK);
    }

    @PostMapping("/")
    public Object createApi(@RequestBody TrustTarget entity) {
        return trustTargetService.createEntity(entity);
    }

    @PutMapping("/")
    public Object updateApi(@RequestBody TrustTarget entity) {
        var response = trustTargetService.updateEntity(entity);
        return response;
    }
    
    @DeleteMapping("/{id}")
    public Object deleteApi(@PathVariable int id){
        var response = trustTargetService.deleteEntity(id);
        return response;
    } 
}
