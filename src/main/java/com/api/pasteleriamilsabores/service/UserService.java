package com.api.pasteleriamilsabores.service;

import com.api.pasteleriamilsabores.model.User;
import com.api.pasteleriamilsabores.model.Rol;
import com.api.pasteleriamilsabores.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolService rolService;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public User saveUser(User user) {
        if (user.getRol() == null) {
            Rol defaultRol = rolService.getRolByName("cliente");
            if (defaultRol == null) {
                throw new RuntimeException("Rol 'cliente' no existe. Créalo antes de registrar usuarios.");
            }
            user.setRol(defaultRol);
        }
        return userRepository.save(user);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public User getUserByEmail(String email) {
        return userRepository.findByMail(email)
                .orElseThrow(() -> new RuntimeException("Usuarioo no encontrado"));
    }
}
