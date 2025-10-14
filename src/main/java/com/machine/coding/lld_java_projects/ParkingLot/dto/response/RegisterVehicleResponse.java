package com.machine.coding.lld_java_projects.ParkingLot.dto.response;

public class RegisterVehicleResponse {
    private Result result;

    //constructor
    public RegisterVehicleResponse(){}

    public RegisterVehicleResponse(String message, boolean success) {
        this.result = new Result(message, success);
    }

    //Getter & Setters
    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    //static inner class Result
    public static class Result{
        private String message;
        private boolean success;

        //Empty Constructor
        public Result() {}
        //All Arg Constructor
        public Result(String message, boolean success) {
            this.message = message;
            this.success = success;
        }

        //Getters & setters
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }
    }
}
