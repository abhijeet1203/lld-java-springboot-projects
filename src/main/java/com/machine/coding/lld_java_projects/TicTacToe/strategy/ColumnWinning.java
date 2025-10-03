package com.machine.coding.lld_java_projects.TicTacToe.strategy;

import com.machine.coding.lld_java_projects.TicTacToe.models.Board;
import com.machine.coding.lld_java_projects.TicTacToe.models.Player;

public class ColumnWinning implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Player player) {
        for(int col = 0; col < board.getSize(); col++){
            boolean colWin = true;
            for(int row = 0; row < board.getSize(); row++){
                if(board.getCell(row, col).getSymbol() != player.getSymbol()){
                    colWin = false;
                    break;
                }
            }
            if (colWin) return true;
        }
        return false;
    }
}
