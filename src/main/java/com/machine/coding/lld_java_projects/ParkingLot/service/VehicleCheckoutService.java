package com.machine.coding.lld_java_projects.ParkingLot.service;

import com.machine.coding.lld_java_projects.ParkingLot.enums.SlotStatuses;
import com.machine.coding.lld_java_projects.ParkingLot.enums.VehicleTypes;
import com.machine.coding.lld_java_projects.ParkingLot.model.Booking;
import com.machine.coding.lld_java_projects.ParkingLot.model.Slot;
import com.machine.coding.lld_java_projects.ParkingLot.repository.BookingRepository;
import com.machine.coding.lld_java_projects.ParkingLot.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VehicleCheckoutService {
    FareCalculationService fareCalculationService;
    @Autowired
    SlotRepository slotRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    public VehicleCheckoutService(FareCalculationService fareCalculationService){
        this.fareCalculationService = fareCalculationService;
    }

    public double checkoutVehicle(VehicleTypes vehicleType, LocalDateTime inTime, LocalDateTime outTime, String slotId, long id){
        //Make slot ID available for other bookings
        Slot slot = slotRepository.findBySlotId(slotId);
        slot.setSlotStatus(SlotStatuses.AVAILABLE.name());
        slotRepository.save(slot);

        //Calculate fare
        double fare = fareCalculationService.calculateFare(vehicleType, inTime, outTime);

        //Input exit time and calculated fare in bookings table
        Booking booking = bookingRepository.findById(id);
        booking.setExit(outTime);
        booking.setFare(fare);
        bookingRepository.save(booking);

        return fare;
    }
}
