package com.api.pasteleriamilsabores.controller;

import com.api.pasteleriamilsabores.model.Product;
import com.api.pasteleriamilsabores.model.User;
import com.api.pasteleriamilsabores.service.ProductService;
import com.api.pasteleriamilsabores.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
@RequestMapping("/api/user")
@Tag(name = "User", description = "User Management System")

public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping
    @Operation(summary = "View a list of available users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get a user by Id")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @PostMapping
    @Operation(summary = "Add a new user")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Update an existing user")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        User existingUser = userService.getUserById(id);
        if (existingUser != null) {
            existingUser.setId(user.getId());
            existingUser.setName(user.getName());
            existingUser.setMail(user.getMail());
            existingUser.setPassword(user.getPassword());
            existingUser.setNumero(user.getNumero());
            existingUser.setPaymentMethod(user.getPaymentMethod());
            return userService.saveUser(existingUser);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
