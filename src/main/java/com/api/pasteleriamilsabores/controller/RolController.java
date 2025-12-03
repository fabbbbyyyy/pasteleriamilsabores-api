package com.api.pasteleriamilsabores.controller;

import com.api.pasteleriamilsabores.model.Rol;
import com.api.pasteleriamilsabores.service.RolService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rol")
@Tag(name = "Rol", description = "Product Type Management System")

public class RolController {

    @Autowired
    private RolService rolService;
    @GetMapping
    @Operation(summary = "View a list of available Roles")
    public List<Rol> getAllRol() { return rolService.getAllRol();}
    
    @GetMapping("/{id}")
    @Operation(summary = "Get a rol by Id")
    public Rol getRolById(@PathVariable Long id) { return rolService.getRolById(id);}
    
    @PostMapping
    @PreAuthorize("hasAuthority('admin')")
    @Operation(summary = "Add a new Rol")
    public Rol createRol(@RequestBody Rol rol) {
        return rolService.saveRol(rol);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin')")
    @Operation(summary = "Update an existing rol")
    public Rol updateRol(@PathVariable Long id, @RequestBody Rol rol) {
        Rol existingRol = rolService.getRolById(id);
        if (existingRol != null) {
            existingRol.setName(rol.getName());
            existingRol.setId(rol.getId());
            return rolService.saveRol(existingRol);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin')")
    @Operation(summary = "Delete a rol")
    public void deleteRol(@PathVariable Long id) {
        rolService.deleteRol(id);
    }
}