package com.machine.coding.lld_java_projects.TicTacToe.strategy;

import com.machine.coding.lld_java_projects.TicTacToe.models.Board;
import com.machine.coding.lld_java_projects.TicTacToe.models.Player;

public class RowWinning implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Player player) {
        for(int row = 0; row < board.getSize(); row++){
            boolean rowWin = true;
            for(int col = 0; col < board.getSize(); col++){
                if(board.getCell(row, col).getSymbol() != player.getSymbol()){
                    rowWin = false;
                    break;
                }
            }
            if (rowWin) return true;
        }
        return false;
    }
}
