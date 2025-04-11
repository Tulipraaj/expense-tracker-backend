package com.tulip.FinProj.service;

import com.tulip.FinProj.entity.User;
import com.tulip.FinProj.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user){
        return userRepository.save(user);
    }

    public Optional<User> getByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public Optional<User> getByEmail(String email){
        return userRepository.findByEmail(email);
    }

}
