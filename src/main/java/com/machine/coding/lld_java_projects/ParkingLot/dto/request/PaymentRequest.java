package com.machine.coding.lld_java_projects.ParkingLot.dto.request;

import com.machine.coding.lld_java_projects.ParkingLot.enums.PaymentMethods;

public class PaymentRequest {
    private String vehicleNumber, vehicleType, slotId;
    private PaymentMethods paymentMethod;
    private double amountToPay;
    private int bookingId;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public PaymentMethods getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethods paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(double amountToPay) {
        this.amountToPay = amountToPay;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public PaymentRequest(String vehicleNumber, String vehicleType, String slotId, PaymentMethods paymentMethod, double amountToPay, int bookingId) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.slotId = slotId;
        this.paymentMethod = paymentMethod;
        this.amountToPay = amountToPay;
        this.bookingId = bookingId;
    }

    public PaymentRequest() {
    }
}
