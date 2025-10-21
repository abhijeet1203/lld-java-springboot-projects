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
        }
    }
}
