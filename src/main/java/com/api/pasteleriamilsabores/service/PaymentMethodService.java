package com.api.pasteleriamilsabores.service;

import com.api.pasteleriamilsabores.model.PaymentMethod;
import com.api.pasteleriamilsabores.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodService {
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;
    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodRepository.findAll();
    }
    public PaymentMethod getPaymentMethodById(Long id) {
        return paymentMethodRepository.findById(id).orElse(null);
    }
    public PaymentMethod savePaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }
    public void deletePaymentMethod(Long id) {
        paymentMethodRepository.deleteById(id);
    }
}
