package com.machine.coding.lld_java_projects.ParkingLot.strategy.fare;

import java.time.LocalDateTime;

public interface FareStrategy {
    double calculateFare(LocalDateTime inTime, LocalDateTime outTime);
}
