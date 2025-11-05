package com.machine.coding.lld_java_projects.ParkingLot.model;

import com.machine.coding.lld_java_projects.ParkingLot.enums.PaymentMethods;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "slot_id")
    private String slotId;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "vehicle_number")
    private String vehicleNumber;

    @Column(name = "ticket")
    private String ticket;

    @Column(name = "entry")
    private LocalDateTime entry;

    @Column(name = "exit")
    private LocalDateTime exit;

    @Column(name = "fare")
    private Double fare;

    @Column(name = "payment_method")
    private PaymentMethods paymentMethod;

    @Column(name = "payment_status")
    private Boolean paymentStatus;

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public PaymentMethods getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethods paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public LocalDateTime getEntry() {
        return entry;
    }

    public void setEntry(LocalDateTime entry) {
        this.entry = entry;
    }

    public LocalDateTime getExit() {
        return exit;
    }

    public void setExit(LocalDateTime exit) {
        this.exit = exit;
    }

    public Booking(long id, String slotId, String vehicleType, String vehicleNumber, String ticket, LocalDateTime entry, LocalDateTime exit, Double fare, PaymentMethods paymentMethod, boolean paymentStatus) {
        this.id = id;
        this.slotId = slotId;
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.ticket = ticket;
        this.entry = entry;
        this.exit = exit;
        this.fare = fare;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public Booking() {
    }

    public static class Builder {
        private String slotId;
        private String vehicleType;
        private String vehicleNumber;
        private String ticket;
        private LocalDateTime entry;
        private LocalDateTime exit;
        private Double fare;
        private PaymentMethods paymentMethod;
        private boolean paymentStatus;

        public Builder slotId(String slotId){
            this.slotId = slotId;
            return this;
        }

        public Builder vehicleType(String vehicleType){
            this.vehicleType = vehicleType;
            return this;
        }

        public Builder vehicleNumber(String vehicleNumber){
            this.vehicleNumber = vehicleNumber;
            return this;
        }

        public Builder ticket(String ticket){
            this.ticket = ticket;
            return this;
        }

        public Builder entry(LocalDateTime entry){
            this.entry = entry;
            return this;
        }

        public Builder exit(LocalDateTime exit){
            this.exit = exit;
            return this;
        }

        public Builder fare(Double fare){
            this.fare = fare;
            return this;
        }

        public Builder paymentMethod(PaymentMethods paymentMethod){
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder paymentStatus(boolean paymentStatus){
            this.paymentStatus = paymentStatus;
            return this;
        }

        public Booking build(){
            Booking booking = new Booking();
            booking.setSlotId(this.slotId);
            booking.setVehicleType(this.vehicleType);
            booking.setExit(this.exit);
            booking.setTicket(this.ticket);
            booking.setEntry(this.entry);
            booking.setVehicleNumber(this.vehicleNumber);
            booking.setFare(this.fare);
            booking.setPaymentMethod(this.paymentMethod);
            booking.setPaymentStatus(this.paymentStatus);
            return booking;
        }
    }
}
