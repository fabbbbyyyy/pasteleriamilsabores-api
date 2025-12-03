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
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.Objects;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User", description = "User Management System")

public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping
    @Operation(summary = "View a list of available users")
    @PreAuthorize("hasAuthority('admin')")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get a user by Id")
    @PreAuthorize("hasAuthority('admin') or principal.username == @userService.getUserById(#id).mail")
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
    @PreAuthorize("hasAuthority('admin') or principal.username == @userService.getUserById(#id).mail")
    public ResponseEntity<?> updateUser(
            @PathVariable Long id,
            @RequestBody User user,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        try {
            User currentUser = userService.getUserByEmail(userDetails.getUsername());
            if (!Objects.equals(currentUser.getId(), id)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN)
                        .body("No tienes permisos para actualizar este usuario");
            }
            User existingUser = userService.getUserById(id);
            if (existingUser != null) {
                existingUser.setName(user.getName());
                existingUser.setMail(user.getMail());
                existingUser.setAddress(user.getAddress());
                existingUser.setNumber(user.getNumber());
                existingUser.setPaymentMethod(user.getPaymentMethod());
                return ResponseEntity.ok(userService.saveUser(existingUser));
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin') or principal.username == @userService.getUserById(#id).mail")
    @Operation(summary = "Delete a user")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
