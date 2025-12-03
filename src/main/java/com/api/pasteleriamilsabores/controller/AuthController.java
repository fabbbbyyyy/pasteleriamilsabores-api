package com.api.pasteleriamilsabores.controller;

import com.api.pasteleriamilsabores.dto.LoginRequest;
import com.api.pasteleriamilsabores.dto.LoginResponse;
import com.api.pasteleriamilsabores.dto.RegisterRequest;
import com.api.pasteleriamilsabores.model.PaymentMethod;
import com.api.pasteleriamilsabores.model.Rol;
import com.api.pasteleriamilsabores.model.User;
import com.api.pasteleriamilsabores.repository.PaymentMethodRepository;
import com.api.pasteleriamilsabores.repository.UserRepository;
import com.api.pasteleriamilsabores.security.jwt.JwtUtil;
import com.api.pasteleriamilsabores.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Autenticar usuario
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );

            // Cargar detalles del usuario
            final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());

            // Generar token
            final String jwt = jwtUtil.generateToken(userDetails.getUsername());

            // Obtener información del usuario
            User user = userRepository.findByMail(loginRequest.getEmail())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            // Obtener roleId desde el campo rol
            Long roleId = null;
            if (user.getRol() != null) {
                roleId = user.getRol().getId();
            }

            // Crear respuesta
            LoginResponse response = new LoginResponse(jwt, user.getMail(), user.getName(), user.getAddress(), user.getNumber(), user.getPaymentMethod(), roleId, user.getId());

            return ResponseEntity.ok(response);

        } catch (BadCredentialsException e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Credenciales inválidas");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Error en el servidor: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        try {
            // Verificar si el email ya existe
            if (userRepository.findByMail(registerRequest.getEmail()).isPresent()) {
                Map<String, String> error = new HashMap<>();
                error.put("message", "El email ya está registrado");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
            }

            // Obtener método de pago
            System.out.println("Metodo de pago: "+registerRequest.getPaymentMethodId());
            PaymentMethod paymentMethod = paymentMethodRepository.findById(registerRequest.getPaymentMethodId())
                    .orElseThrow(() -> new RuntimeException("Método de pago no encontrado"));

            // Crear nuevo usuario
            User newUser = new User();
            newUser.setName(registerRequest.getName());
            newUser.setMail(registerRequest.getEmail());
            newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            newUser.setNumber(registerRequest.getNumber());
            newUser.setAddress(registerRequest.getAddress());
            newUser.setPaymentMethod(paymentMethod);

            // Guardar usuario usando UserService para asignar rol por defecto
            userService.saveUser(newUser);

            // Obtener roleId desde el campo rol
            Long roleId = null;
            if (newUser.getRol() != null) {
                roleId = newUser.getRol().getId();
            }

            // Generar token
            final String jwt = jwtUtil.generateToken(newUser.getMail());

            // Crear respuesta
            LoginResponse response = new LoginResponse(jwt, newUser.getMail(), newUser.getName(), newUser.getAddress(), newUser.getNumber(), newUser.getPaymentMethod(), roleId, newUser.getId());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Error al registrar usuario: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }
}
