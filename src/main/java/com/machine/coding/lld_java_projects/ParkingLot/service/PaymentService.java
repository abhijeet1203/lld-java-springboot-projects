package com.machine.coding.lld_java_projects.ParkingLot.service;

import com.machine.coding.lld_java_projects.ParkingLot.enums.PaymentMethods;
import com.machine.coding.lld_java_projects.ParkingLot.model.Booking;
import com.machine.coding.lld_java_projects.ParkingLot.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    PaymentCompletionService paymentCompletionService;

    public boolean makePayment(PaymentMethods paymentMethod, double amount, long bookingId){
        System.out.println("Payment method" + paymentMethod);
        boolean isPaymentSuccessful =  paymentCompletionService.makePayment(paymentMethod, amount);
        Booking booking = bookingRepository.findById(bookingId);
        booking.setPaymentMethod(paymentMethod);
        booking.setPaymentStatus(isPaymentSuccessful);
        bookingRepository.save(booking);
        return isPaymentSuccessful;
    }
}
