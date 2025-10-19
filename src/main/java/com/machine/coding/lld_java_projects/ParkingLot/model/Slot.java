package com.machine.coding.lld_java_projects.ParkingLot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "slots")
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "slot_id")
    private String slotId;

    @Column(name = "slot_status")
    private String slotStatus;

    @Column(name = "vehicle_type")
    private String vehicleType;

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

    public String getSlotStatus() {
        return slotStatus;
    }

    public void setSlotStatus(String slotStatus) {
        this.slotStatus = slotStatus;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", slotId='" + slotId + '\'' +
                ", slotStatus='" + slotStatus + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }
}
