package com.machine.coding.lld_java_projects.ParkingLot.controller;

import com.machine.coding.lld_java_projects.ParkingLot.dto.request.*;
import com.machine.coding.lld_java_projects.ParkingLot.dto.response.*;
import com.machine.coding.lld_java_projects.ParkingLot.enums.PaymentMethods;
import com.machine.coding.lld_java_projects.ParkingLot.enums.VehicleTypes;
import com.machine.coding.lld_java_projects.ParkingLot.model.Slot;
import com.machine.coding.lld_java_projects.ParkingLot.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//Exposes all API
@RestController
@RequestMapping("/v1/api/parking-lot")
public class ParkingController {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private SlotService slotService;
    @Autowired
    private SlotConfirmationService slotConfirmationService;
    @Autowired
    private VehicleCheckoutService vehicleCheckoutService;
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/vehicles/register")
    public ResponseEntity<RegisterVehicleResponse> registerVehicle(@RequestBody RegisterVehicleRequest request){
        try{
            boolean isVehicleRegistered = vehicleService.registerVehicle(request);
            if(isVehicleRegistered){
                return ResponseEntity.ok(new RegisterVehicleResponse("Vehicle Registration Successful", true));
            }else {
                return ResponseEntity.badRequest().body(new RegisterVehicleResponse("Vehicle Registration Successful", true));
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new RegisterVehicleResponse("Vehicle Registration Failed",false));
        }
    }

    @GetMapping("/slots/available")
    public ResponseEntity<FetchAvailableSlotResponse> fetchAvailableSlots(@ModelAttribute FetchAvailableSlotRequest request){
        try{
            //Get available slots
            List<Slot> availableSlots = slotService.fetchAvailableSlots(request.getVehicleType());
            //Fetch slot Ids
            List<String> slotIds = new ArrayList<>();
            for (Slot slot : availableSlots){
                slotIds.add(slot.getSlotId());
            }
            //Build Result object
            FetchAvailableSlotResponse.Result result = new FetchAvailableSlotResponse.Result();
            result.setMessage("Fetched Available Slots");
            result.setSuccess(true);
            result.setIsParkingFull(slotIds.isEmpty());
            result.setSlotAvailable(slotIds);
            result.setVehicleType(request.getVehicleType());

            //Build Response object
            FetchAvailableSlotResponse response = new FetchAvailableSlotResponse(result);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            //Build Result object
            FetchAvailableSlotResponse.Result failedResult = new FetchAvailableSlotResponse.Result();
            failedResult.setMessage("Failed To Fetch Available Slots");
            failedResult.setSuccess(false);
            failedResult.setVehicleType(request.getVehicleType());

            //Build Response object
            FetchAvailableSlotResponse response = new FetchAvailableSlotResponse(failedResult);
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @PostMapping("/slots/confirmation")
    public ResponseEntity<SlotConfirmationResponse> confirmSlot(@RequestBody SlotConfirmationRequest request){
        try{
            String bookedTicket = slotConfirmationService.confirmBooking(request);

            SlotConfirmationResponse.Result result = new SlotConfirmationResponse.Result();
            result.setMessage("Slot confirmed successfully");
            result.setSuccess(true);
            result.setTicket(bookedTicket);

            SlotConfirmationResponse.Result.VehicleData vehicleData = new SlotConfirmationResponse.Result.VehicleData();
            vehicleData.setType(request.getVehicleType());
            vehicleData.setRegistrationNumber(request.getVehicleNumber());

            SlotConfirmationResponse.Result.ConfirmedSlotData confirmedSlotData = new SlotConfirmationResponse.Result.ConfirmedSlotData();
            confirmedSlotData.setSlotStatus("OCCUPIED");
            confirmedSlotData.setSlotId(request.getSlotToConfirm());

            result.setConfirmedSlotData(confirmedSlotData);
            result.setVehicleData(vehicleData);

            SlotConfirmationResponse response = new SlotConfirmationResponse(result);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            SlotConfirmationResponse.Result failedResult = new SlotConfirmationResponse.Result();
            failedResult.setMessage("Slot confirmation failed");
            failedResult.setSuccess(false);
            failedResult.setError(e.getMessage());

            SlotConfirmationResponse failedResponse = new SlotConfirmationResponse(failedResult);
            return ResponseEntity.internalServerError().body(failedResponse);
        }
    }

    @PostMapping("/vehicle/checkout")
    public ResponseEntity<VehicleCheckoutResponse> checkoutVehicle(@RequestBody VehicleCheckoutRequest request){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            String inTime = request.getInTime();
            LocalDateTime parsedInTime = LocalDateTime.parse(inTime, formatter);
            VehicleTypes vehicleType = request.getVehicleType();
            String slotId = request.getSlotId();
            LocalDateTime outTime = LocalDateTime.now();
            long bookingId = request.getBookingId();

            double calculatedFare = vehicleCheckoutService.checkoutVehicle(vehicleType, parsedInTime, outTime, slotId, bookingId);

            VehicleCheckoutResponse.Result result = new VehicleCheckoutResponse.Result();

            result.setCurrency("INR");
            result.setFare(calculatedFare);
            result.setMessage("Vehicle checkout successfully done");
            result.setSuccess(true);
            result.setVehicleType(vehicleType);
            result.setInTime(parsedInTime);
            result.setVehicleNumber(request.getVehicleNumber());
            result.setOutTime(outTime);
            result.setSlotId(slotId);

            VehicleCheckoutResponse response = new VehicleCheckoutResponse(result);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            VehicleCheckoutResponse.Result failedResult = new VehicleCheckoutResponse.Result();

            failedResult.setSuccess(false);
            failedResult.setMessage("Vehicle checkout failed");
            failedResult.setError(e.getMessage());

            VehicleCheckoutResponse response = new VehicleCheckoutResponse(failedResult);
            return ResponseEntity.internalServerError().body(response);
        }
    }
    @PostMapping("/vehicle/payments")
    public ResponseEntity<PaymentResponse>completePayment(@RequestBody PaymentRequest request){
        try{
            PaymentMethods paymentMethod = request.getPaymentMethod();
            boolean isPaymentSuccess = paymentService.makePayment(paymentMethod, request.getAmountToPay(), request.getBookingId());
            PaymentResponse.Result result = new PaymentResponse.Result();
            if(isPaymentSuccess){
                result.setAmountPaid(request.getAmountToPay());
                result.setCurrency("INR");
                result.setMessage("Payment successful");
                result.setPaymentMethod(paymentMethod);
                result.setSuccess(isPaymentSuccess);
                result.setVehicleType(request.getVehicleType());
                result.setSlotId(request.getSlotId());
                result.setVehicleNumber(request.getVehicleNumber());

                PaymentResponse response = new PaymentResponse(result);
                return ResponseEntity.ok(response);
            }else {
                result.setAmountPaid(request.getAmountToPay());
                result.setCurrency("INR");
                result.setMessage("Payment failed");
                result.setPaymentMethod(paymentMethod);
                result.setSuccess(isPaymentSuccess);
                result.setVehicleType(request.getVehicleType());
                result.setSlotId(request.getSlotId());
                result.setVehicleNumber(request.getVehicleNumber());

                PaymentResponse response = new PaymentResponse(result);
                return ResponseEntity.ok(response);
            }
        } catch (Exception e) {
            PaymentResponse.Result failedResult = new PaymentResponse.Result();
            failedResult.setAmountPaid(request.getAmountToPay());
            failedResult.setCurrency("INR");
            failedResult.setMessage("Error, payment failed");
            failedResult.setSuccess(false);
            failedResult.setVehicleType(request.getVehicleType());
            failedResult.setSlotId(request.getSlotId());
            failedResult.setVehicleNumber(request.getVehicleNumber());
            failedResult.setError(e.getMessage());

            PaymentResponse response = new PaymentResponse(failedResult);
            return ResponseEntity.internalServerError().body(response);
        }
    }
}
