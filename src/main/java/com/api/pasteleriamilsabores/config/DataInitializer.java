package com.api.pasteleriamilsabores.config;

import com.api.pasteleriamilsabores.model.PaymentMethod;
import com.api.pasteleriamilsabores.model.ProductType;
import com.api.pasteleriamilsabores.repository.PaymentMethodRepository;
import com.api.pasteleriamilsabores.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        // Inicializar métodos de pago si no existen
        if (paymentMethodRepository.count() == 0) {
            System.out.println("Inicializando métodos de pago...");

            PaymentMethod efectivo = new PaymentMethod();
            efectivo.setName("Efectivo");
            paymentMethodRepository.save(efectivo);

            PaymentMethod tarjeta = new PaymentMethod();
            tarjeta.setName("Tarjeta de Crédito");
            paymentMethodRepository.save(tarjeta);

            PaymentMethod transferencia = new PaymentMethod();
            transferencia.setName("Transferencia Bancaria");
            paymentMethodRepository.save(transferencia);

            PaymentMethod paypal = new PaymentMethod();
            paypal.setName("PayPal");
            paymentMethodRepository.save(paypal);

            System.out.println("✅ Métodos de pago inicializados correctamente");
        }
        System.out.println("🚀 Aplicación lista para usar!");
    }
}

