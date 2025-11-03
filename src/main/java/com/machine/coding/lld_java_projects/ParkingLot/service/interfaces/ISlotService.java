package com.machine.coding.lld_java_projects.ParkingLot.service.interfaces;

import com.machine.coding.lld_java_projects.ParkingLot.dto.request.SlotConfirmationRequest;

public interface ISlotService {
    String confirmBooking(SlotConfirmationRequest request);
    void occupySlot(String slotId);
    String generateTicket();
}
