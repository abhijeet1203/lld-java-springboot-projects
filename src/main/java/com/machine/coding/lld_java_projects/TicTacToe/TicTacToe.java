package com.machine.coding.lld_java_projects.TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int gridSize = 3;

        System.out.println("Enter name of player 1 (X): ");
        String player1 = scanner.nextLine();

        System.out.println("Enter name of player 2 (O): ");
        String player2 = scanner.nextLine();

        GameController controller = new GameController(player1, player2, gridSize);
        controller.initializeGame();
    }
}
