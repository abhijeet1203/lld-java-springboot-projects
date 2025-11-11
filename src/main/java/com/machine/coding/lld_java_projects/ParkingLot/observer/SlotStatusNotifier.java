package com.machine.coding.lld_java_projects.ParkingLot.observer;

import java.util.ArrayList;

public class SlotStatusNotifier implements SlotStatusSubject{
    private final ArrayList<SlotStatusObserver> observers = new ArrayList<>();
    @Override
    public void addObserver(SlotStatusObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removedObserver(SlotStatusObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(String slotId, String status) {
        for (SlotStatusObserver observer : observers){
            observer.update(slotId, status);
        }
    }
}
