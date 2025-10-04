package com.soen343.tbd.application.controller;

import com.soen343.tbd.infrastructure.persistence.entity.User;
import com.soen343.tbd.application.dto.LoginRequest;
import com.soen343.tbd.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    // This class will contain the endpoints for user-related operations

    @Autowired
    UserService userService; // Uncomment when UserService is implemented
    @PostMapping ("/addUser")
    @CrossOrigin(origins = "http://localhost:3000")
   public User addUser(@RequestBody User user) {
        // In a real application, you would call a service to handle business logic
        // For simplicity, we are just returning the user object received in the request
        return userService.addUser(user);
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000")
    public Boolean login(@RequestBody LoginRequest loginRequest){
        return userService.loginUser(loginRequest);
    }
}
