package com.machine.coding.lld_java_projects.TicTacToe.state;

import com.machine.coding.lld_java_projects.TicTacToe.Game;
import com.machine.coding.lld_java_projects.TicTacToe.models.Player;

public interface GameState {
    void handleMove(Game game, Player player, int row, int column);
}
