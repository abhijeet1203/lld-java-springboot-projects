package com.machine.coding.lld_java_projects.ParkingLot.repository;

import com.machine.coding.lld_java_projects.ParkingLot.model.Slot;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {
    List<Slot> findByVehicleTypeAndSlotStatus(String vehicleType, String slotStatus);
    Slot findBySlotId(String slotId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Slot findBySlotIdForUpdate(@Param("slotId") String slotId);
}
