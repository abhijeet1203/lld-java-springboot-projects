package com.machine.coding.lld_java_projects.TicTacToe.state;

import com.machine.coding.lld_java_projects.TicTacToe.Game;
import com.machine.coding.lld_java_projects.TicTacToe.exception.InvalidMoveException;
import com.machine.coding.lld_java_projects.TicTacToe.models.Player;

public class Winner implements GameState{
    @Override
    public void handleMove(Game game, Player player, int row, int column) {
        throw new InvalidMoveException("Game is already over. " + game.getWinner() + " has won.");
    }
}
