package com.machine.coding.lld_java_projects.ParkingLot.service.interfaces;

import com.machine.coding.lld_java_projects.ParkingLot.enums.PaymentMethods;

public interface IPaymentService {
    boolean makePayment(PaymentMethods paymentMethod, double amount, long bookingId);
}
