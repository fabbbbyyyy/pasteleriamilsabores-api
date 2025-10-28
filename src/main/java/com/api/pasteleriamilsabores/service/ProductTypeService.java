package com.api.pasteleriamilsabores.service;

import com.api.pasteleriamilsabores.model.ProductType;
import com.api.pasteleriamilsabores.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;
    public List<ProductType> getAllProductTypes() {
        return productTypeRepository.findAll();
    }
    public ProductType getProductTypeById(Long id) {
        return productTypeRepository.findById(id).orElse(null);
    }
    public ProductType saveProductType(ProductType productType) {
        return productTypeRepository.save(productType);
    }
    public void deleteProductType(Long id) {
        productTypeRepository.deleteById(id);
    }
}
