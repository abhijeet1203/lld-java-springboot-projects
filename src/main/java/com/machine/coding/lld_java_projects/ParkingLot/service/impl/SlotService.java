package com.machine.coding.lld_java_projects.ParkingLot.service.impl;

import com.machine.coding.lld_java_projects.ParkingLot.enums.SlotStatuses;
import com.machine.coding.lld_java_projects.ParkingLot.model.Slot;
import com.machine.coding.lld_java_projects.ParkingLot.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotService {
    @Autowired
    private SlotRepository slotRepository;
    public List<Slot> fetchAvailableSlots(String vehicleType){
        return slotRepository.findByVehicleTypeAndSlotStatus(vehicleType, SlotStatuses.AVAILABLE.name());
    }
}
