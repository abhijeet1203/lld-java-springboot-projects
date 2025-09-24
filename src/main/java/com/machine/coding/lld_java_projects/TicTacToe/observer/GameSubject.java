package com.machine.coding.lld_java_projects.TicTacToe.observer;

public interface GameSubject {
    void addObserver(GameObserver observer);
    void removeObserver(GameObserver observer);
    void notifyObserver();
}