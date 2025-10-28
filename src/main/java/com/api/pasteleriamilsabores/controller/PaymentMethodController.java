package com.api.pasteleriamilsabores.controller;

import com.api.pasteleriamilsabores.model.PaymentMethod;
import com.api.pasteleriamilsabores.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
@RequestMapping("/api/payment_method")
@Tag(name = "Payment Method", description = "Payment Method Management System")


public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;
    @GetMapping
    @Operation(summary = "View a list of available paymentMethods")
    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodService.getAllPaymentMethods();
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get a paymentMethod by Id")
    public PaymentMethod getPaymentMethodById(@PathVariable Long id) {
        return paymentMethodService.getPaymentMethodById(id);
    }
    @PostMapping
    @Operation(summary = "Add a new paymentMethod")
    public PaymentMethod createPaymentMethod(@RequestBody PaymentMethod paymentMethod) {
        return paymentMethodService.savePaymentMethod(paymentMethod);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Update an existing paymentMethod")
    public PaymentMethod updatePaymentMethod(@PathVariable Long id, @RequestBody PaymentMethod paymentMethod) {
        PaymentMethod existingPaymentMethod = paymentMethodService.getPaymentMethodById(id);
        if (existingPaymentMethod != null) {
            existingPaymentMethod.setName(paymentMethod.getName());
            existingPaymentMethod.setId(paymentMethod.getId());
            return paymentMethodService.savePaymentMethod(existingPaymentMethod);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a paymentMethod")
    public void deletePaymentMethod(@PathVariable Long id) {
        paymentMethodService.deletePaymentMethod(id);
    }
}
