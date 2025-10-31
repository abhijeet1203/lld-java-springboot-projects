package com.machine.coding.lld_java_projects.ParkingLot.dto.response;

import com.machine.coding.lld_java_projects.ParkingLot.enums.PaymentMethods;

public class PaymentResponse {
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public PaymentResponse(Result result) {
        this.result = result;
    }

    public PaymentResponse() {
    }

    public static class Result{
        private String message, vehicleNumber, vehicleType, slotId, currency, error;
        private PaymentMethods paymentMethod;
        private double amountPaid;
        private boolean success;

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

        public String getVehicleType() {
            return vehicleType;
        }

        public void setVehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
        }

        public String getSlotId() {
            return slotId;
        }

        public void setSlotId(String slotId) {
            this.slotId = slotId;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public PaymentMethods getPaymentMethod() {
            return paymentMethod;
        }

        public void setPaymentMethod(PaymentMethods paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public double getAmountPaid() {
            return amountPaid;
        }

        public void setAmountPaid(double amountPaid) {
            this.amountPaid = amountPaid;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public Result(String message, String vehicleNumber, String vehicleType, String slotId, String currency, PaymentMethods paymentMethod, String error, double amountPaid, boolean success) {
            this.message = message;
            this.vehicleNumber = vehicleNumber;
            this.vehicleType = vehicleType;
            this.slotId = slotId;
            this.currency = currency;
            this.paymentMethod = paymentMethod;
            this.error = error;
            this.amountPaid = amountPaid;
            this.success = success;
        }

        public Result() {
        }
    }
}
