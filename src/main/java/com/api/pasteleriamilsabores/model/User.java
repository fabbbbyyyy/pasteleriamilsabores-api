package com.api.pasteleriamilsabores.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name = "users")

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String mail;

    @Column
    private String address;

    @Column
    private String number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_method", nullable = false)
    private PaymentMethod paymentMethod;
}
