package com.machine.coding.lld_java_projects.TicTacToe;

import com.machine.coding.lld_java_projects.TicTacToe.enums.Symbols;
import com.machine.coding.lld_java_projects.TicTacToe.models.Board;
import com.machine.coding.lld_java_projects.TicTacToe.models.Player;
import com.machine.coding.lld_java_projects.TicTacToe.observer.Scoreboard;

public class GameController {
    String player1, player2;
    int gridSize;

    public GameController(String player1, String player2, int gridSize) {
        this.player1 = player1;
        this.player2 = player2;
        this.gridSize = gridSize;
    }

    public void initializeGame(){
        /*
        * ToDO
        *   Register the player - Done
        *   Create Board - Done
        *   Initialize the game business logic - Done
        *   Initiate scoreboard - Done
        * */
        System.out.println("Registering both players");
        Player playerA = new Player(player1, Symbols.X);
        Player playerB = new Player(player2, Symbols.O);

        System.out.println("Players registered successfully");
        System.out.println("1st player is " + playerA.getPlayerName() + " with symbol " + playerA.getSymbol());
        System.out.println("2nd player is " + playerB.getPlayerName() + " with symbol " + playerB.getSymbol());

        System.out.println("Creating game board");
        Board board = new Board(gridSize);

        Game game = new Game(playerA, playerB, board);

        Scoreboard scoreboard = new Scoreboard();
        System.out.println("Creating scoreboard");
        game.addObserver(scoreboard);

        System.out.println("Starting the game");
        game.start();
    }
}
