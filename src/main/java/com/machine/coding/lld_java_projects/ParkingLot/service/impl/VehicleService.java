package com.machine.coding.lld_java_projects.ParkingLot.service.impl;

import com.machine.coding.lld_java_projects.ParkingLot.dto.request.RegisterVehicleRequest;
import com.machine.coding.lld_java_projects.ParkingLot.model.Vehicle;
import com.machine.coding.lld_java_projects.ParkingLot.repository.VehicleRepository;
import com.machine.coding.lld_java_projects.ParkingLot.service.interfaces.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Override
    public boolean registerVehicle(RegisterVehicleRequest request){
        try{
            Vehicle vehicle = new Vehicle.Builder()
                    .registrationNumber(request.getVehicleNumber())
                            .type(request.getVehicleType())
                                    .entryDate(LocalDateTime.now())
                                            .build();


            vehicleRepository.save(vehicle);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
