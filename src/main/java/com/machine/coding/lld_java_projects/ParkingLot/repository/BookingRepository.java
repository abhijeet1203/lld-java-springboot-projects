package com.machine.coding.lld_java_projects.ParkingLot.repository;

import com.machine.coding.lld_java_projects.ParkingLot.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
