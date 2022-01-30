package com.coder.financeApp.controller;

import com.coder.financeApp.exception.ResourceNotFoundException;
import com.coder.financeApp.model.User;
import com.coder.financeApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    public ResponseEntity<List<User>> getAllCashFlow() {
        return ResponseEntity.ok().body(service.getAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") long userId)
            throws ResourceNotFoundException {
        User user = service.findById(userId);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User u = service.insert(user);
        return ResponseEntity.ok().body(u);
    }



}
