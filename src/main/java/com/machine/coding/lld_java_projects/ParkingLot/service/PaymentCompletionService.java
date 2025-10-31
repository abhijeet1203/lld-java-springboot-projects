package com.machine.coding.lld_java_projects.ParkingLot.service;

import com.machine.coding.lld_java_projects.ParkingLot.enums.PaymentMethods;
import com.machine.coding.lld_java_projects.ParkingLot.strategy.payments.PaymentStrategy;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentCompletionService {
    private final Map<String, PaymentStrategy> paymentStrategies;

    public PaymentCompletionService(Map<String, PaymentStrategy> paymentStrategies){
        this.paymentStrategies = paymentStrategies;
    }

    public boolean makePayment(PaymentMethods paymentMethod, double amount){
        PaymentStrategy strategy = paymentStrategies.get(paymentMethod.name());
        System.out.println("Strategy is " + strategy);
        return strategy.makePayment(amount);
    }
}
