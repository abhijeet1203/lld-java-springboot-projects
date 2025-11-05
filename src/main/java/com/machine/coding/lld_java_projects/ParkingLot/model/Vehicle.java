package com.machine.coding.lld_java_projects.ParkingLot.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "type")
    private String type;

    @Column(name = "entry_date")
    private LocalDateTime entryDate;

    //Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public static class Builder {
        private String registrationNumber;
        private String type;
        private LocalDateTime entryDate;

        public Builder registrationNumber(String registrationNumber){
            this.registrationNumber = registrationNumber;
            return this;
        }

        public Builder type(String type){
            this.type = type;
            return this;
        }

        public Builder entryDate(LocalDateTime entryDate){
            this.entryDate = entryDate;
            return this;
        }

        public Vehicle build(){
            Vehicle vehicle = new Vehicle();
            vehicle.setRegistrationNumber(this.registrationNumber);
            vehicle.setType(this.type);
            vehicle.setEntryDate(this.entryDate);
            return vehicle;
        }
    }
}
