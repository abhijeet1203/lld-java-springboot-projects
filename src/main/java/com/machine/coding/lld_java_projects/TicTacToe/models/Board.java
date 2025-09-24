package com.machine.coding.lld_java_projects.TicTacToe.models;

import com.machine.coding.lld_java_projects.TicTacToe.enums.Symbols;

public class Board {
    private final int gridSize;
    private final Symbols[][] grid;

    public Board(int gridSize){
        this.gridSize = gridSize;
        this.grid = new Symbols[gridSize][gridSize];
        initializeBoard();
    }

    private void initializeBoard(){
        for (int i = 0; i < gridSize; i++){
            for (int j = 0; j < gridSize; j++){
                grid[i][j] = Symbols.EMPTY;
            }
        }
    }

    public void displayBoard(){
        for(int i = 0; i < gridSize; i++){
            for (int j = 0; j < gridSize; j++){
                System.out.print(" " + grid[i][j].getSymbol() + " ");
                if(j < gridSize - 1) System.out.print("|");
            }
            System.out.println();
            if(i < gridSize - 1) System.out.println("---".repeat(gridSize + 1));
        }
    }
}