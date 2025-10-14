package com.machine.coding.lld_java_projects.ParkingLot.controller;

import com.machine.coding.lld_java_projects.ParkingLot.dto.request.RegisterVehicleRequest;
import com.machine.coding.lld_java_projects.ParkingLot.dto.response.RegisterVehicleResponse;
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
    @PostMapping("/vehicles/register")
    public ResponseEntity<RegisterVehicleResponse> registerVehicle(@RequestBody RegisterVehicleRequest request){
        RegisterVehicleResponse response = new RegisterVehicleResponse("Vehicle registered successfully", true);
        return ResponseEntity.ok(response);
    }
}
