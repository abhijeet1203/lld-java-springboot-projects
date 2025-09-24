package com.machine.coding.lld_java_projects.TicTacToe;

import com.machine.coding.lld_java_projects.TicTacToe.enums.Status;
import com.machine.coding.lld_java_projects.TicTacToe.models.Board;
import com.machine.coding.lld_java_projects.TicTacToe.models.Player;
import com.machine.coding.lld_java_projects.TicTacToe.observer.GameObserver;
import com.machine.coding.lld_java_projects.TicTacToe.observer.GameSubject;
import com.machine.coding.lld_java_projects.TicTacToe.state.GameState;
import com.machine.coding.lld_java_projects.TicTacToe.state.InProgress;
import com.machine.coding.lld_java_projects.TicTacToe.strategy.ColumnWinning;
import com.machine.coding.lld_java_projects.TicTacToe.strategy.DiagonalWinning;
import com.machine.coding.lld_java_projects.TicTacToe.strategy.RowWinning;
import com.machine.coding.lld_java_projects.TicTacToe.strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game implements GameSubject {
    private Player player1, player2, currentPlayer;
    private Board board;
    private Status status;
    private GameState state;

    private final List<WinningStrategy> winningStrategies;
    private final List<GameObserver> observers = new ArrayList<>();

    Game(Player player1, Player player2, Board board){
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.board = board;
        this.status = Status.IN_PROGRESS;
        this.state = new InProgress();
        this.winningStrategies = List.of(new RowWinning(), new ColumnWinning(), new DiagonalWinning());
    }

    @Override
    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(GameObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {

    }

    void start(){
        /*
        * TODO
        *   Display game board - Done
        *   Use GameStatus enums to show actual game status - Done
        *   Initialize GameState strategy - Done
        *   Choose current player - Done
        *   makeMove - Handle and validate move - Put move into desired cell chosen by the player | check move correctness
        *   checkWinner post every move
        *   Initialize winningStrategy
        *   Switch player
        * */
        System.out.println("Started the game with player - " + currentPlayer.getPlayerName());
        System.out.println("Game status is " + Status.IN_PROGRESS);
        board.displayBoard();
        makeMove();
    }

    void makeMove(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(currentPlayer.getPlayerName() + ", please provide valid row for your move");
        int row = scanner.nextInt();
        System.out.println(currentPlayer.getPlayerName() + ", please provide valid column for your move");
        int column = scanner.nextInt();

        //Delegate to inProgress State
        state.handleMove(this, currentPlayer, row, column);
    }
}
