package com.machine.coding.lld_java_projects.ParkingLot.observer;

public class DisplayBoardService implements SlotStatusObserver{
    @Override
    public void update(String slotId, String status) {
        System.out.println("DisplayBoard Updated: Slot " + slotId + " is now " + status);
    }
}
