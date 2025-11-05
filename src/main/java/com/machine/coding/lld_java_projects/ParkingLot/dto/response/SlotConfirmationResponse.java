package com.machine.coding.lld_java_projects.ParkingLot.dto.response;

public class SlotConfirmationResponse {
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public SlotConfirmationResponse(Result result) {
        this.result = result;
    }

    public SlotConfirmationResponse() {
    }

    public static class Result{
        private String message;
        private boolean success;
        private String ticket;
        private String error;
        private VehicleData vehicleData;
        private ConfirmedSlotData confirmedSlotData;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public boolean getSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getTicket() {
            return ticket;
        }

        public void setTicket(String ticket) {
            this.ticket = ticket;
        }

        public VehicleData getVehicleData() {
            return vehicleData;
        }

        public void setVehicleData(VehicleData vehicleData) {
            this.vehicleData = vehicleData;
        }

        public ConfirmedSlotData getConfirmedSlotData() {
            return confirmedSlotData;
        }

        public void setConfirmedSlotData(ConfirmedSlotData confirmedSlotData) {
            this.confirmedSlotData = confirmedSlotData;
        }

        public Result(String message, boolean success, String ticket, VehicleData vehicleData, ConfirmedSlotData confirmedSlotData, String error) {
            this.message = message;
            this.success = success;
            this.ticket = ticket;
            this.vehicleData = vehicleData;
            this.confirmedSlotData = confirmedSlotData;
            this.error = error;
        }

        public Result() {
        }

        public static class Builder{
            private String message;
            private boolean success;
            private String ticket;
            private VehicleData vehicleData;
            private ConfirmedSlotData confirmedSlotData;
            private String error;

            public Builder message(String message){
                this.message = message;
                return this;
            }

            public Builder success(boolean success){
                this.success = success;
                return this;
            }

            public Builder ticket(String ticket){
                this.ticket = ticket;
                return this;
            }

            public Builder vehicleData(VehicleData vehicleData){
                this.vehicleData = vehicleData;
                return this;
            }

            public Builder confirmedSlotData(ConfirmedSlotData confirmedSlotData){
                this.confirmedSlotData = confirmedSlotData;
                return this;
            }

            public Builder error(String error){
                this.error = error;
                return this;
            }

            public Result build(){
                Result result = new Result();
                result.setError(this.error);
                result.setMessage(this.message);
                result.setSuccess(this.success);
                result.setTicket(this.ticket);
                result.setConfirmedSlotData(this.confirmedSlotData);
                result.setVehicleData(this.vehicleData);
                return result;
            }
        }

        public static class VehicleData{
            private String type;
            private String registrationNumber;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getRegistrationNumber() {
                return registrationNumber;
            }

            public void setRegistrationNumber(String registrationNumber) {
                this.registrationNumber = registrationNumber;
            }

            public VehicleData(String type, String registrationNumber) {
                this.type = type;
                this.registrationNumber = registrationNumber;
            }

            public VehicleData() {
            }

            public static class Builder{
                private String type;
                private String registrationNumber;

                public Builder type(String type){
                    this.type = type;
                    return this;
                }

                public Builder registrationNumber(String registrationNumber){
                    this.registrationNumber = registrationNumber;
                    return this;
                }

                public VehicleData build(){
                    VehicleData vehicleData = new VehicleData();
                    vehicleData.setRegistrationNumber(this.registrationNumber);
                    vehicleData.setType(this.type);
                    return vehicleData;
                }
            }
        }

        public static class ConfirmedSlotData{
            private String slotId;
            private String slotStatus;

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

            public ConfirmedSlotData(String slotId, String slotStatus) {
                this.slotId = slotId;
                this.slotStatus = slotStatus;
            }

            public ConfirmedSlotData(){}

            public static class Builder{
                private String slotId;
                private String slotStatus;

                public Builder slotId(String slotId){
                    this.slotId = slotId;
                    return this;
                }

                public Builder slotStatus(String slotStatus){
                    this.slotStatus = slotStatus;
                    return this;
                }

                public ConfirmedSlotData build(){
                    ConfirmedSlotData confirmedSlotData = new ConfirmedSlotData();
                    confirmedSlotData.setSlotId(this.slotId);
                    confirmedSlotData.setSlotStatus(this.slotStatus);
                    return confirmedSlotData;
                }
            }
        }
    }
}
