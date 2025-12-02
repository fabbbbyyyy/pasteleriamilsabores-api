package com.api.pasteleriamilsabores.service;


import com.api.pasteleriamilsabores.model.Rol;
import com.api.pasteleriamilsabores.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;
    public List<Rol> getAllRol() {return rolRepository.findAll();}
    public Rol getRolById(Long id) {
        return rolRepository.findById(id).orElse(null);
    }
    public Rol saveRol(Rol rol) {
        return rolRepository.save(rol);
    }
    public void deleteRol(Long id) {
        rolRepository.deleteById(id);
    }
}