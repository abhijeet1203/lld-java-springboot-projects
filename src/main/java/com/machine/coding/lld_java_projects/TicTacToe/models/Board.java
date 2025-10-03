package com.machine.coding.lld_java_projects.TicTacToe.models;

import com.machine.coding.lld_java_projects.TicTacToe.enums.Symbols;
import com.machine.coding.lld_java_projects.TicTacToe.exception.InvalidMoveException;

public class Board {
    private final int gridSize;
    private final Cell[][] board;
    private int movesCount;

    public Board(int gridSize){
        this.gridSize = gridSize;
        this.board = new Cell[gridSize][gridSize];
        movesCount = 0;
        initializeBoard();
    }

    private void initializeBoard(){
        for (int i = 0; i < gridSize; i++){
            for (int j = 0; j < gridSize; j++){
                board[i][j] = new Cell();
            }
        }
    }

    public void displayBoard(){
        for(int i = 0; i < gridSize; i++){
            for (int j = 0; j < gridSize; j++){
                System.out.print(" " + board[i][j].getSymbol().getChar() + " ");
                if(j < gridSize - 1) System.out.print("|");
            }
            System.out.println();
            if(i < gridSize - 1) System.out.println("---".repeat(gridSize + 1));
        }
    }

    public void placeSymbol(int row, int column, Symbols symbol){
        if(row < 0 || row >= gridSize || column < 0 || column >= gridSize){
            throw new InvalidMoveException("Not a valid move. Out of bound");
        }
        if(board[row][column].getSymbol() != Symbols.EMPTY){
            throw new InvalidMoveException("Invalid position: cell is already occupied.");
        }
        board[row][column].setSymbol(symbol);
        movesCount++;
        System.out.println("Move placed successfully");
    }

    public boolean isBoardFull(){
        return movesCount == gridSize * gridSize;
    }

    public Cell getCell(int row, int col){
        if(row < 0 || row >= gridSize || col < 0 || col >= gridSize) {
            return null;
        }
        return board[row][col];
    }
    public int getSize(){ return gridSize; }
}