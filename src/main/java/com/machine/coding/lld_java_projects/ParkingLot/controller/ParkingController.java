package com.machine.coding.lld_java_projects.ParkingLot.controller;

import com.machine.coding.lld_java_projects.ParkingLot.dto.request.RegisterVehicleRequest;
import com.machine.coding.lld_java_projects.ParkingLot.dto.response.RegisterVehicleResponse;
import com.machine.coding.lld_java_projects.ParkingLot.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Exposes all API
@RestController
@RequestMapping("/v1/api/parking-lot")
public class ParkingController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/vehicles/register")
    public ResponseEntity<RegisterVehicleResponse> registerVehicle(@RequestBody RegisterVehicleRequest request){
        try{
            System.out.println("Received vehicle registration request: " + request.getVehicleNumber() + ", " + request.getVehicleType());
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
}
