package com.api.pasteleriamilsabores.dto;

import com.api.pasteleriamilsabores.model.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private Long id;
    private String token;
    private String type = "Bearer";
    private String email;
    private String name;
    private String number;
    private String address;
    private PaymentMethod paymentMethod;
    private Long roleId; // nuevo campo para devolver el id del rol


    public LoginResponse(String token, String email, String name, String address, String number, PaymentMethod paymentMethod, Long roleId, Long id) {
        this.token = token;
        this.email = email;
        this.name = name;
        this.address = address;
        this.number = number;
        this.paymentMethod = paymentMethod;
        this.roleId = roleId;
        this.id = id;
    }
}
