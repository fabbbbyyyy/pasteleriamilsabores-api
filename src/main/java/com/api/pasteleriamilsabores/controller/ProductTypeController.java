package com.api.pasteleriamilsabores.controller;

import com.api.pasteleriamilsabores.model.ProductType;
import com.api.pasteleriamilsabores.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
@RequestMapping("/api/product_type")
@Tag(name = "Product Type", description = "Product Type Management System")

public class ProductTypeController {
    
    @Autowired
    private ProductTypeService productTypeService;
    @GetMapping
    @Operation(summary = "View a list of available productTypes")
    public List<ProductType> getAllProductTypes() {
        return productTypeService.getAllProductTypes();
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get a productType by Id")
    public ProductType getProductTypeById(@PathVariable Long id) {
        return productTypeService.getProductTypeById(id);
    }
    @PostMapping
    @Operation(summary = "Add a new productType")
    public ProductType createProductType(@RequestBody ProductType productType) {
        return productTypeService.saveProductType(productType);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Update an existing productType")
    public ProductType updateProductType(@PathVariable Long id, @RequestBody ProductType productType) {
        ProductType existingProductType = productTypeService.getProductTypeById(id);
        if (existingProductType != null) {
            existingProductType.setName(productType.getName());
            existingProductType.setId(productType.getId());
            return productTypeService.saveProductType(existingProductType);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a productType")
    public void deleteProductType(@PathVariable Long id) {
        productTypeService.deleteProductType(id);
    }
}
