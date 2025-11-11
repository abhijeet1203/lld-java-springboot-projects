package com.machine.coding.lld_java_projects.ParkingLot.observer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObserverConfig {
    @Bean
    public SlotStatusNotifier slotStatusNotifier(DisplayBoardService displayBoardService, LoggingService loggingService){
        SlotStatusNotifier notifier = new SlotStatusNotifier();
        notifier.addObserver(displayBoardService);
        notifier.addObserver(loggingService);
        return notifier;
    }
}
