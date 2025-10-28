package com.api.pasteleriamilsabores.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name="product")

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, unique = true)
    private int price;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id",nullable = false)
    private ProductType productType;

}
