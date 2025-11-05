package com.machine.coding.lld_java_projects.ParkingLot.dto.response;

import java.util.List;

public class FetchAvailableSlotResponse {
    private Result result;

    public FetchAvailableSlotResponse(Result result) {
        this.result = result;
    }

    public FetchAvailableSlotResponse() {}

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result{
        private String message;
        private boolean success;
        private boolean isParkingFull;
        private String vehicleType;
        private List<String> slotAvailable;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public boolean getSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public boolean getIsParkingFull() {
            return isParkingFull;
        }

        public void setIsParkingFull(boolean isParkingFull) {
            this.isParkingFull = isParkingFull;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public void setVehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
        }

        public List<String> getSlotAvailable() {
            return slotAvailable;
        }

        public void setSlotAvailable(List<String> slotAvailable) {
            this.slotAvailable = slotAvailable;
        }

        public Result(String message, boolean success, boolean isParkingFull, String vehicleType, List<String> slotAvailable) {
            this.message = message;
            this.success = success;
            this.isParkingFull = isParkingFull;
            this.vehicleType = vehicleType;
            this.slotAvailable = slotAvailable;
        }

        public Result() {
        }

        public static class Builder{
            private String message;
            private boolean success;
            private boolean isParkingFull;
            private String vehicleType;
            private List<String> slotAvailable;

            public Builder message(String message){
                this.message = message;
                return this;
            }

            public Builder success(boolean success){
                this.success = success;
                return this;
            }

            public Builder isParkingFull(boolean isParkingFull){
                this.isParkingFull = isParkingFull;
                return this;
            }

            public Builder vehicleType(String vehicleType){
                this.vehicleType = vehicleType;
                return this;
            }

            public Builder slotAvailable(List<String> slotAvailable){
                this.slotAvailable = slotAvailable;
                return this;
            }

            public Result build(){
                Result result = new Result();
                result.setVehicleType(this.vehicleType);
                result.setMessage(this.message);
                result.setSlotAvailable(this.slotAvailable);
                result.setSuccess(this.success);
                result.setIsParkingFull(this.isParkingFull);
                return result;
            }
        }
    }
}
