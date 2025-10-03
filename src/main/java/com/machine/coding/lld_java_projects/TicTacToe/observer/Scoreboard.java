package com.machine.coding.lld_java_projects.TicTacToe.observer;

import com.machine.coding.lld_java_projects.TicTacToe.Game;
import com.machine.coding.lld_java_projects.TicTacToe.enums.Status;

public class Scoreboard implements GameObserver{
    @Override
    public void updateGame(Game game) {
        System.out.println("\n--- Scoreboard Update ---");

        if (game.getStatus() == Status.WINNER_X || game.getStatus() == Status.WINNER_O) {
            System.out.println("🎉 " + game.getWinner().getPlayerName() + " has won the game!");
        } else if (game.getStatus() == Status.DRAW) {
            System.out.println("🤝 The game ended in a draw.");
        }

        System.out.println("Final Board:");
        game.getBoard().displayBoard();
        System.out.println("-------------------------\n");
    }
}
