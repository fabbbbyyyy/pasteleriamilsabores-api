package com.api.pasteleriamilsabores.dto;

import com.api.pasteleriamilsabores.model.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String token;
    private String type = "Bearer";
    private String email;
    private String name;
    private String number;
    private String address;
    private PaymentMethod paymentMethod;


    public LoginResponse(String token, String email, String name, String number, String address, PaymentMethod paymentMethod) {
        this.token = token;
        this.email = email;
        this.name = name;
        this.number = number;
        this.address = address;
        this.paymentMethod = paymentMethod;
    }
}

