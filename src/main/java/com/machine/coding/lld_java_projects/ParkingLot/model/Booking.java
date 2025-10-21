package com.machine.coding.lld_java_projects.ParkingLot.model;

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

    public Booking(long id, String slotId, String ticket, String vehicleType, String vehicleNumber, LocalDateTime entry, LocalDateTime exit) {
        this.id = id;
        this.slotId = slotId;
        this.ticket = ticket;
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.entry = entry;
        this.exit = exit;
    }

    public Booking() {
    }
}
