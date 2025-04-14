package com.tulip.FinProj.controller;

import com.tulip.FinProj.entity.User;
import com.tulip.FinProj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; // Add this

    @PostMapping("/register")
    public User register(@RequestBody User user){
        // Encode the password before saving
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword); // Set the encoded password

        return userService.register(user); // Call the service to save the user
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username){
        return userService.getByUsername(username).orElse(null);
    }
}
