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

import com.trustTarget.trustTarget.model.TrustNivels;
import com.trustTarget.trustTarget.service.TrustNivelService;

@RestController
@RequestMapping("api/v1/trustNivels")
public class TrustNivelsController {
    @Autowired
    private TrustNivelService trustNivelService;

    @GetMapping("")
    public ResponseEntity<Object> getAllApi(){
        var listQuery = trustNivelService.getAll();
        return new ResponseEntity<Object>(listQuery, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getByIdApi(@PathVariable int id) {
        var query = trustNivelService.getById(id);
        return new ResponseEntity<Object>(query, HttpStatus.OK);
    }

    @PostMapping("/")
    public Object createApi(@RequestBody TrustNivels entity) {
        return trustNivelService.createEntity(entity);
    }

    @PutMapping("/")
    public Object updateApi(@RequestBody TrustNivels entity) {
        var response = trustNivelService.updateEntity(entity);
        return response;
    }
    
    @DeleteMapping("/{id}")
    public Object deleteApi(@PathVariable int id){
        var response = trustNivelService.deleteEntity(id);
        return response;
    } 
}
