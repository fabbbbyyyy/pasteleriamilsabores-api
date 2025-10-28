package com.api.pasteleriamilsabores.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name="user")

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

    private String numero;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paymentMethod",nullable = false)
    private PaymentMethod paymentMethod;

}
