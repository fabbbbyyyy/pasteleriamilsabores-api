package com.api.pasteleriamilsabores.service;

import com.api.pasteleriamilsabores.model.User;
import com.api.pasteleriamilsabores.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public User getUserByEmail(String email) {
        return userRepository.findByMail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}

