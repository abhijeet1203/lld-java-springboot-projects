package com.machine.coding.lld_java_projects.TicTacToe.state;

import com.machine.coding.lld_java_projects.TicTacToe.Game;
import com.machine.coding.lld_java_projects.TicTacToe.enums.Status;
import com.machine.coding.lld_java_projects.TicTacToe.enums.Symbols;
import com.machine.coding.lld_java_projects.TicTacToe.exception.InvalidMoveException;
import com.machine.coding.lld_java_projects.TicTacToe.models.Player;

public class InProgress implements GameState{
    @Override
    public void handleMove(Game game, Player player, int row, int column) {
        /*
        * TODO
        *  Check if Player is same as current player in the game
        *  Put the move in the board
        *  Check winner strategy
        * */
        System.out.println("Handling the move...");
        // Check if Player is same as current player in the game
        if(game.getCurrentPlayer() != player){
            throw new InvalidMoveException("Not your turn");
        }
        // Get the board and place the move on the board
        game.getBoard().placeSymbol(row, column, player.getSymbol());

        // Check for a winner or a draw
        if (game.checkWinner(player)) {
            game.setWinner(player);
            game.setStatus(player.getSymbol() == Symbols.X ? Status.WINNER_X : Status.WINNER_O);
            game.setState(new Winner());
            game.notifyObserver();
        } else if (game.getBoard().isBoardFull()) {
            game.setStatus(Status.DRAW);
            game.setState(new Draw());
            game.notifyObserver();
        } else {
            // If the game is still in progress, switch players
            System.out.println("Game in progress...");
            game.getBoard().displayBoard();
            game.switchPlayer();
        }
    }
}
