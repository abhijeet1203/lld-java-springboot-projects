package com.machine.coding.lld_java_projects.ParkingLot.observer;

public interface SlotStatusObserver {
    void update(String slotId, String status);
}
