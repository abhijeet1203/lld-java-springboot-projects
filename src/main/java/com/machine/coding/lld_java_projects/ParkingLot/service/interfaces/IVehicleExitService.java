package com.machine.coding.lld_java_projects.ParkingLot.service.interfaces;

import com.machine.coding.lld_java_projects.ParkingLot.enums.VehicleTypes;

import java.time.LocalDateTime;

public interface IVehicleExitService {
    double checkoutVehicle(VehicleTypes vehicleType, LocalDateTime inTime, LocalDateTime outTime, String slotId, long id);
}
