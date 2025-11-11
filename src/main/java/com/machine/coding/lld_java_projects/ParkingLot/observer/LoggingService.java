package com.machine.coding.lld_java_projects.ParkingLot.observer;

public class LoggingService implements SlotStatusObserver{
    @Override
    public void update(String slotId, String status) {
        System.out.println("Loggers update: Slot " + slotId + " is now " + status);
    }
}
