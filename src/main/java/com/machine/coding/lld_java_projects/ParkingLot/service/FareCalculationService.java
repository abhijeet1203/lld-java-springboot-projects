package com.machine.coding.lld_java_projects.ParkingLot.service;

import com.machine.coding.lld_java_projects.ParkingLot.enums.VehicleTypes;
import com.machine.coding.lld_java_projects.ParkingLot.strategy.FareStrategy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class FareCalculationService {
    private final Map<String, FareStrategy> fareStrategies;

    public FareCalculationService(Map<String, FareStrategy> fareStrategies){
        this.fareStrategies = fareStrategies;
    }

    public double calculateFare(VehicleTypes vehicleType, LocalDateTime inTime, LocalDateTime outTime){
        FareStrategy strategy = fareStrategies.get(vehicleType.name());

        if(strategy == null){
            throw new IllegalArgumentException("No fare strategy found for vehicle type: " + vehicleType);
        }
        return strategy.calculateFare(inTime, outTime);
    }
}
