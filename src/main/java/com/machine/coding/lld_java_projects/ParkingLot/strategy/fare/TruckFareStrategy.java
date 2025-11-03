package com.machine.coding.lld_java_projects.ParkingLot.strategy.fare;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("TRUCK")
public class TruckFareStrategy implements FareStrategy{
    @Override
    public double calculateFare(LocalDateTime inTime, LocalDateTime outTime){
        long hours = Duration.between(inTime, outTime).toHours();
        if(hours == 0) hours = 1;

        return hours * 70;//70 per hour
    }
}
