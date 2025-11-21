package com.api.pasteleriamilsabores.controller;

import com.api.pasteleriamilsabores.model.Product;
import com.api.pasteleriamilsabores.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
@RequestMapping("/api/product")
@Tag(name = "Product", description = "Product Management System")

public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    @Operation(summary = "View a list of available products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get a product by Id")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    @PostMapping
    @Operation(summary = "Add a new product")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Update an existing product")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product existingProduct = productService.getProductById(id);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setId(product.getId());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setProductType(product.getProductType());
            return productService.saveProduct(existingProduct);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a product")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/category/{categoryId}")
    @Operation(summary = "Get products by category")
    public List<Product> getProductsByCategory(@PathVariable Long categoryId) {
        return productService.getProductsByCategory(categoryId);
    }
}
