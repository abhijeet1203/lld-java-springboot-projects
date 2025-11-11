package com.machine.coding.lld_java_projects.ParkingLot.observer;

public interface SlotStatusSubject {
    void addObserver(SlotStatusObserver observer);
    void removedObserver(SlotStatusObserver observer);
    void notifyObserver(String slotId, String status);
}
