package com.machine.coding.lld_java_projects.ParkingLot.dto.response;

import com.machine.coding.lld_java_projects.ParkingLot.dto.request.VehicleCheckoutRequest;
import com.machine.coding.lld_java_projects.ParkingLot.enums.VehicleTypes;

import java.time.LocalDateTime;

public class VehicleCheckoutResponse {
    private Result result;

    public VehicleCheckoutResponse(){}

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result{
        private boolean success;
        private String message;
        private String vehicleNumber;
        private VehicleTypes vehicleType;
        private String slotId;
        private LocalDateTime inTime;
        private LocalDateTime outTime;
        private String currency;
        private double fare;
        private String error;

        public Result(boolean success, String message, String vehicleNumber, VehicleTypes vehicleType, String slotId, LocalDateTime inTime, LocalDateTime outTime, String currency, double fare, String error) {
            this.success = success;
            this.message = message;
            this.vehicleNumber = vehicleNumber;
            this.vehicleType = vehicleType;
            this.slotId = slotId;
            this.inTime = inTime;
            this.outTime = outTime;
            this.currency = currency;
            this.fare = fare;
            this.error = error;
        }

        public Result(){}

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getVehicleNumber() {
            return vehicleNumber;
        }

        public void setVehicleNumber(String vehicleNumber) {
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

        public LocalDateTime getInTime() {
            return inTime;
        }

        public void setInTime(LocalDateTime inTime) {
            this.inTime = inTime;
        }

        public LocalDateTime getOutTime() {
            return outTime;
        }

        public void setOutTime(LocalDateTime outTime) {
            this.outTime = outTime;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public double getFare() {
            return fare;
        }

        public void setFare(double fare) {
            this.fare = fare;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public VehicleCheckoutResponse(Result result) {
        this.result = result;
    }
}
