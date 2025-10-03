package com.machine.coding.lld_java_projects.TicTacToe.enums;

public enum Symbols {
    X('X'),
    O('O'),
    EMPTY('_');

    private final char symbol;
    Symbols(char symbol){
        this.symbol = symbol;
    }

    public char getChar(){
        return symbol;
    }
}
