package com.machine.coding.lld_java_projects.TicTacToe;

import com.machine.coding.lld_java_projects.TicTacToe.game.GameController;
import com.machine.coding.lld_java_projects.TicTacToe.models.Player;
import com.machine.coding.lld_java_projects.TicTacToe.models.Symbol;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Tic-Tac-Toe!");

        Scanner scanner = new Scanner(System.in);

        // Read player 1 details
        System.out.print("Enter Player 1 name: ");
        String name1 = scanner.nextLine();
        Player player1 = new Player(name1, Symbol.X);

        //Read player 2 details
        System.out.println("Enter player 2 name: ");
        String name2 = scanner.nextLine();
        Player player2 = new Player(name2, Symbol.O);

        //Initialize game controller
        GameController gameController = new GameController(player1, player2);
    }
}
