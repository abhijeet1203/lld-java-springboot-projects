package com.machine.coding.lld_java_projects.TicTacToe.game;

import com.machine.coding.lld_java_projects.TicTacToe.models.Board;
import com.machine.coding.lld_java_projects.TicTacToe.models.GameStatus;
import com.machine.coding.lld_java_projects.TicTacToe.models.Player;
import com.machine.coding.lld_java_projects.TicTacToe.utils.ConsolePrinter;

import java.util.Scanner;

public class GameController {
    private final Player player1;
    private final Player player2;
    private final Board board;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private final ResultValidator resultValidator;

    public GameController(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.board = new Board(3);
        this.gameStatus = GameStatus.IN_PROGRESS;
        this. resultValidator = new ResultValidator();
    }

    public void startGame(){
        Scanner scanner = new Scanner(System.in);

        while (gameStatus == GameStatus.IN_PROGRESS){
            ConsolePrinter.printBoard(board);

            System.out.println(currentPlayer.getName() + "'s turn. Enter row and column (0-indexed):");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            /*
            * TODO
            *  Validate move
            *  Update Board
            *  Check Result
            *  Switch Player
            * */

            break;
        }
    }
}
