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

import com.trustTarget.trustTarget.model.User;
import com.trustTarget.trustTarget.service.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllApi(){
        var listQuery = userService.getAll();
        return new ResponseEntity<Object>(listQuery, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getByIdApi(@PathVariable Long id) {
        var query = userService.getById(id);
        return new ResponseEntity<Object>(query, HttpStatus.OK);
    }
    
    @GetMapping("nameQuery/{name}")
    public ResponseEntity<Object> getByNameApi(@PathVariable String name) {
        var query = userService.queryUserName(name);
        return new ResponseEntity<Object>(query, HttpStatus.OK);
    }

    @PostMapping("/")
    public Object createApi(@RequestBody User entity) {
        return userService.createEntity(entity);
    }

    @PutMapping("/")
    public Object updateApi(@RequestBody User entity) {
        var response = userService.updateEntity(entity);
        return response;
    }
    
    @DeleteMapping("/{id}")
    public Object deleteApi(@PathVariable Long id){
        var response = userService.deleteEntity(id);
        return response;
    } 
}
