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

import com.trustTarget.trustTarget.model.Rating;
import com.trustTarget.trustTarget.service.RatingService;

@RestController
@RequestMapping("api/v1/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @GetMapping("")
    public ResponseEntity<Object> getAllApi(){
        var listQuery = ratingService.getAll();
        return new ResponseEntity<Object>(listQuery, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getByIdApi(@PathVariable int id) {
        var query = ratingService.getById(id);
        return new ResponseEntity<Object>(query, HttpStatus.OK);
    }

    @PostMapping("/")
    public Object createApi(@RequestBody Rating entity) {
        return ratingService.createEntity(entity);
    }

    @PutMapping("/")
    public Object updateApi(@RequestBody Rating entity) {
        var response = ratingService.updateEntity(entity);
        return response;
    }
    
    @DeleteMapping("/{id}")
    public Object deleteApi(@PathVariable int id){
        var response = ratingService.deleteEntity(id);
        return response;
    } 
}
