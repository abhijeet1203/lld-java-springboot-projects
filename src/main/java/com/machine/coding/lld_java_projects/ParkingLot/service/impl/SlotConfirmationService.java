package com.machine.coding.lld_java_projects.ParkingLot.service.impl;

import com.machine.coding.lld_java_projects.ParkingLot.dto.request.SlotConfirmationRequest;
import com.machine.coding.lld_java_projects.ParkingLot.enums.SlotStatuses;
import com.machine.coding.lld_java_projects.ParkingLot.model.Booking;
import com.machine.coding.lld_java_projects.ParkingLot.model.Slot;
import com.machine.coding.lld_java_projects.ParkingLot.repository.BookingRepository;
import com.machine.coding.lld_java_projects.ParkingLot.repository.SlotRepository;
import com.machine.coding.lld_java_projects.ParkingLot.service.interfaces.ISlotService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SlotConfirmationService implements ISlotService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private SlotRepository slotRepository;

    @Override
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

    //Below code with Synchronized is very simple and only used for single instance projects, not for live production ready projects
    //Reentrant lock can also be used for better control

    //    public void occupySlot(String slotId){
    //        synchronized (slotId.intern()){
    //            Slot slot = slotRepository.findBySlotId(slotId);
    //            if(SlotStatuses.OCCUPIED.name().equals(slot.getSlotStatus())){
    //                throw new IllegalStateException("Slot already occupied!");
    //            }
    //            slot.setSlotStatus(SlotStatuses.OCCUPIED.name());
    //            slotRepository.save(slot);
    //        }
    //    }

    //----BETTER APPROACH----
    @Transactional
    @Override
    public void occupySlot(String slotId){
        Slot slot = slotRepository.findBySlotIdForUpdate(slotId); //row-level locking
        if(SlotStatuses.OCCUPIED.name().equals(slot.getSlotStatus())){
            throw new IllegalStateException("Slot already occupied!");
        }
        slot.setSlotStatus(SlotStatuses.OCCUPIED.name());
        slotRepository.save(slot);
    }

    @Override
    public String generateTicket(){
        System.out.println("Ticket generated and saved successfully");
        return "https://gcloud.bucket.ticket-001";
    }
}
