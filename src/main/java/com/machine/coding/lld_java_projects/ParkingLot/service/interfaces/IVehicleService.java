package com.machine.coding.lld_java_projects.ParkingLot.service.interfaces;

import com.machine.coding.lld_java_projects.ParkingLot.dto.request.RegisterVehicleRequest;

public interface IVehicleService {
    boolean registerVehicle(RegisterVehicleRequest request);
}
