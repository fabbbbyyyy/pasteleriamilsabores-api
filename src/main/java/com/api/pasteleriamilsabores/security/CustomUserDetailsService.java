package com.api.pasteleriamilsabores.security;

import com.api.pasteleriamilsabores.model.User;
import com.api.pasteleriamilsabores.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByMail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con email: " + email));

        List<GrantedAuthority> authorities = new ArrayList<>();
        if (user.getRol() != null && user.getRol().getName() != null) {
            // Normalizar a minúsculas: evita problemas de mayúsculas/minúsculas en las comprobaciones hasAuthority
            authorities.add(new SimpleGrantedAuthority(user.getRol().getName().toLowerCase()));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getMail(),
                user.getPassword(),
                authorities
        );
    }
}
