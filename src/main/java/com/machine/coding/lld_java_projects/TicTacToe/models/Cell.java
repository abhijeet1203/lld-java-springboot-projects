package com.machine.coding.lld_java_projects.TicTacToe.models;

import com.machine.coding.lld_java_projects.TicTacToe.enums.Symbols;

public class Cell {
    private Symbols symbol;

    public Cell(){
        this.symbol = Symbols.EMPTY;
    }

    public Symbols getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbols symbol) {
        this.symbol = symbol;
    }
}
