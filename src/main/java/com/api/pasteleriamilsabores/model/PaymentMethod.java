package com.api.pasteleriamilsabores.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name="payment_method")

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;
}
