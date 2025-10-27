package com.machine.coding.lld_java_projects.ParkingLot.service;

import com.machine.coding.lld_java_projects.ParkingLot.dto.request.SlotConfirmationRequest;
import com.machine.coding.lld_java_projects.ParkingLot.enums.SlotStatuses;
import com.machine.coding.lld_java_projects.ParkingLot.model.Booking;
import com.machine.coding.lld_java_projects.ParkingLot.model.Slot;
import com.machine.coding.lld_java_projects.ParkingLot.repository.BookingRepository;
import com.machine.coding.lld_java_projects.ParkingLot.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SlotConfirmationService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private SlotRepository slotRepository;

    public String confirmBooking(SlotConfirmationRequest request){
        //Insert Record in Bookings table
        Booking booking = new Booking();
        booking.setEntry(LocalDateTime.now());
        booking.setSlotId(request.getSlotToConfirm());
        booking.setVehicleNumber(request.getVehicleNumber());
        booking.setVehicleType(request.getVehicleType());

        //Update Slots table
        occupySlot(request.getSlotToConfirm());
        //Generate ticket
        String ticket = generateTicket();
        booking.setTicket(ticket);
        bookingRepository.save(booking);

        return ticket;
    }

    private void occupySlot(String slotId){
        Slot slot = slotRepository.findBySlotId(slotId);
        slot.setSlotStatus(SlotStatuses.OCCUPIED.name());
        slotRepository.save(slot);
    }

    private String generateTicket(){
        System.out.println("Ticket generated and saved successfully");
        return "https://gcloud.bucket.ticket-001";
    }
}
