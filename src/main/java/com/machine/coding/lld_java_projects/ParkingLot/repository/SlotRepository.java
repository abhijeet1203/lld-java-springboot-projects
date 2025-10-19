package com.machine.coding.lld_java_projects.ParkingLot.repository;

import com.machine.coding.lld_java_projects.ParkingLot.model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Long> {
    List<Slot> findByVehicleTypeAndSlotStatus(String vehicleType, String slotStatus);
}
