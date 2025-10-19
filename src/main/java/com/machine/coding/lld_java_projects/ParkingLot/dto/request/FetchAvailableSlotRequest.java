package com.machine.coding.lld_java_projects.ParkingLot.dto.request;

public class FetchAvailableSlotRequest {
    private String vehicleType;

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public FetchAvailableSlotRequest(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public FetchAvailableSlotRequest() {
    }
}
