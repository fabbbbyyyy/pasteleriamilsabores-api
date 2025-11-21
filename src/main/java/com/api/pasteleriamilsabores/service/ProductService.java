package com.api.pasteleriamilsabores.service;

import com.api.pasteleriamilsabores.model.Product;
import com.api.pasteleriamilsabores.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findByProductTypeId(categoryId);
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
