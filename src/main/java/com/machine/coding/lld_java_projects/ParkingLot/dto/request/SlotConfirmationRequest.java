package com.machine.coding.lld_java_projects.ParkingLot.dto.request;

public class SlotConfirmationRequest {
    private String vehicleType;
    private String vehicleNumber;
    private String slotToConfirm;

    public String getVehicleType(){
        return vehicleType;
    }

    public void setVehicleType(String vehicleType){
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getSlotToConfirm() {
        return slotToConfirm;
    }

    public void setSlotToConfirm(String slotToConfirm) {
        this.slotToConfirm = slotToConfirm;
    }

    public SlotConfirmationRequest(){}

    public SlotConfirmationRequest(String vehicleType, String vehicleNumber, String slotToConfirm){
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.slotToConfirm = slotToConfirm;
    }
}
