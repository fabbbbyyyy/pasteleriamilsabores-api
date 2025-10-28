package com.api.pasteleriamilsabores.repository;
import com.api.pasteleriamilsabores.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
