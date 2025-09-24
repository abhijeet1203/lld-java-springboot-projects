package com.machine.coding.lld_java_projects.TicTacToe.models;

import com.machine.coding.lld_java_projects.TicTacToe.enums.Symbols;

public class Player {
    String playerName;
    Symbols symbol;

    public Player(String playerName, Symbols symbol){
        this.playerName = playerName;
        this.symbol = symbol;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Symbols getSymbol() {
        return symbol;
    }
}
