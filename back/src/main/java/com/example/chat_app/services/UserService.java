package com.example.chat_app.services;

import com.example.chat_app.model.User;
import com.example.chat_app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

}
