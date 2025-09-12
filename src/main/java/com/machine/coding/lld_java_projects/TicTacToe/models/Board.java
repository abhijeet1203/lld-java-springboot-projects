package com.machine.coding.lld_java_projects.TicTacToe.models;

public class Board {
    private final int size;
    private final Symbol[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new Symbol[size][size];
        initializeBoard();
    }

    private void initializeBoard(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                grid[i][j] = null;
            }
        }
    }
}
