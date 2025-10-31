package com.machine.coding.lld_java_projects.ParkingLot.strategy.payments;

import org.springframework.stereotype.Component;

@Component("UPI")
public class UPIPaymentStrategy implements PaymentStrategy{
    @Override
    public boolean makePayment(double amount) {
        try {
            System.out.println("Going to make payment of Rs." + amount + " via UPI");
            System.out.println("UPI Payment successful for amount of Rs." + amount);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
