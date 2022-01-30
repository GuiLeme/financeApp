package com.coder.financeApp.service;

import com.coder.financeApp.exception.ResourceNotFoundException;
import com.coder.financeApp.model.User;
import com.coder.financeApp.repository.UserRepository;
import com.coder.financeApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public User findById(Long userId) throws ResourceNotFoundException {
        return repository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Flux not found: " + userId));
    }

    public User insert(User user){
        return repository.save(user);
    }

    public List<User> getAllUser(){
        return repository.findAll();
    }
}

