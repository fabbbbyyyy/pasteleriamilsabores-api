package com.api.pasteleriamilsabores.repository;

import com.api.pasteleriamilsabores.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface ProductRepository extends JpaRepository<Product, Long> {
}
