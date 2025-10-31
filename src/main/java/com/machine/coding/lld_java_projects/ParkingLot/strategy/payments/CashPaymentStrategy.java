package com.machine.coding.lld_java_projects.ParkingLot.strategy.payments;

import org.springframework.stereotype.Component;

@Component("CASH")
public class CashPaymentStrategy implements PaymentStrategy{
    @Override
    public boolean makePayment(double amount){
        try {
            System.out.println("Going to make payment of Rs." + amount + " via Cash");
            System.out.println("Cash Payment successful for amount of Rs." + amount);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
