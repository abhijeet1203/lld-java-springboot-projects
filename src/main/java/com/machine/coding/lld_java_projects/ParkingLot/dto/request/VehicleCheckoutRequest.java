package com.machine.coding.lld_java_projects.ParkingLot.dto.request;

import com.machine.coding.lld_java_projects.ParkingLot.enums.VehicleTypes;

public class VehicleCheckoutRequest {
    private String vehicleNumber;
    private VehicleTypes vehicleType;
    private String slotId;
    private String inTime;
    private long bookingId;

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public String getVehicleNumber(){
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber){
        this.vehicleNumber = vehicleNumber;
    }


    public VehicleTypes getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleTypes vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public VehicleCheckoutRequest(){}

    public VehicleCheckoutRequest(String vehicleNumber, VehicleTypes vehicleType, String slotId, String inTime, long bookingId){
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.slotId = slotId;
        this.inTime = inTime;
        this.bookingId = bookingId;
    }
}
