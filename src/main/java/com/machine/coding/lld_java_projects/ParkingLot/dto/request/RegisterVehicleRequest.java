package com.machine.coding.lld_java_projects.ParkingLot.dto.request;

public class RegisterVehicleRequest {
    private String vehicleNumber;
    private String vehicleType;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String getVehicleType) {
        this.vehicleType = vehicleType;
    }

    public RegisterVehicleRequest(String vehicleNumber, String getVehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public RegisterVehicleRequest() {}
}
