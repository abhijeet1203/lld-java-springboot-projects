package com.machine.coding.lld_java_projects.ParkingLot.controller;

import com.machine.coding.lld_java_projects.ParkingLot.dto.request.FetchAvailableSlotRequest;
import com.machine.coding.lld_java_projects.ParkingLot.dto.request.RegisterVehicleRequest;
import com.machine.coding.lld_java_projects.ParkingLot.dto.request.SlotConfirmationRequest;
import com.machine.coding.lld_java_projects.ParkingLot.dto.response.FetchAvailableSlotResponse;
import com.machine.coding.lld_java_projects.ParkingLot.dto.response.RegisterVehicleResponse;
import com.machine.coding.lld_java_projects.ParkingLot.dto.response.SlotConfirmationResponse;
import com.machine.coding.lld_java_projects.ParkingLot.model.Slot;
import com.machine.coding.lld_java_projects.ParkingLot.service.SlotConfirmationService;
import com.machine.coding.lld_java_projects.ParkingLot.service.SlotService;
import com.machine.coding.lld_java_projects.ParkingLot.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
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
}
