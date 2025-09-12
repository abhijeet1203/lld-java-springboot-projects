package com.machine.coding.lld_java_projects.TicTacToe.models;

public class Player {
    private final String name;
    private final Symbol symbol;

    public Player(String name, Symbol symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", symbol=" + symbol +
                '}';
    }
}
/*
Can be extended like - [To Support Bot Player, Human Player]
public abstract class Player {
    protected String name;
    protected Symbol symbol;

    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public abstract Move makeMove(Board board);
}
*/
