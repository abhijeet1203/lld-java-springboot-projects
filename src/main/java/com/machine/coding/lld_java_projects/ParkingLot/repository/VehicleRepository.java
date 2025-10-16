package com.machine.coding.lld_java_projects.ParkingLot.repository;

import com.machine.coding.lld_java_projects.ParkingLot.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
