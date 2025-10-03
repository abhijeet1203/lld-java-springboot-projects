package com.machine.coding.lld_java_projects.TicTacToe.strategy;

import com.machine.coding.lld_java_projects.TicTacToe.models.Board;
import com.machine.coding.lld_java_projects.TicTacToe.models.Player;

public interface WinningStrategy {
    boolean checkWinner(Board board, Player player);
}
